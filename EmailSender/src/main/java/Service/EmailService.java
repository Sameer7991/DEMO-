package Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import DTO.EmailDTO;
import Entities.Email;
import Repository.EmailRepo;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepo emailRepo;

    public void sendEmail(EmailDTO dto) {
        // Send Email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        message.setText(dto.getBody());
        mailSender.send(message);

        // Save to DB
        Email entity = new Email(dto.getTo(), dto.getSubject(), dto.getBody());
        emailRepo.save(entity);
    }
}
