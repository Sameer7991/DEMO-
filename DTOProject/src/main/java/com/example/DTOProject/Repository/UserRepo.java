package com.example.DTOProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DTOProject.Entities.User;


public interface UserRepo extends JpaRepository<User, Integer> {

}
