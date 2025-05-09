package Reposiatory;


import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
