package Service;

import java.util.List;

import DTO.StudentRequest;
import DTO.StudentResponse;

public interface StudentService {
    List<StudentResponse> getAllStudents();
    StudentResponse addStudent(StudentRequest request);
}
