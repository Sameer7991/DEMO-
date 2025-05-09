package ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.StudentRequest;
import DTO.StudentResponse;
import Entities.Student;
import Reposiatory.StudentRepo;
import Service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepo.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse addStudent(StudentRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .course(request.getCourse())
                .build();

        return convertToResponse(studentRepo.save(student));
    }

    private StudentResponse convertToResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .course(student.getCourse())
                .build();
    }
}
