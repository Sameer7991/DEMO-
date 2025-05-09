package ServiceImpl;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import DTO.EmailDTO;
import Entities.Email;
import Repository.EmailRepo;
import Service.EmailService;

@Service

public class EmailImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EmailRepo emailRepo;
	
	
	
	@Override
	public void sendEmail(EmailDTO dto) {
		
		if (dto.getTo() == null || dto.getTo().isEmpty()) {
			throw new IllegalArgumentException("Recipient email cannot be empty");
		}
		
		try {
		// -> 1. Send the email
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("samfoode@gmail.com");
			message.setTo(dto.getTo());
			message.setSubject(dto.getSubject());
			message.setText(dto.getBody());
		
			mailSender.send(message);
		
		// 2. Save to database
		
			Email email = new Email();
			email.setRecipient(dto.getTo());
			email.setSubject(dto.getSubject());
			email.setBody(dto.getBody());
			email.setSentAt(LocalDateTime.now());
		
			emailRepo.save(email);
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to send email: " + e.getMessage());
		}
					
	}
	
	
}