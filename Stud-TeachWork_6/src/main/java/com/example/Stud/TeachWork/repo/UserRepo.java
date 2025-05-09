package com.example.Stud.TeachWork.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Stud.TeachWork.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);

}
