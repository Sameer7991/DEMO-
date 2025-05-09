package com.example.DTOProject.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTOProject.DTO.UserRequest;
import com.example.DTOProject.DTO.UserResponse;
import com.example.DTOProject.Entities.User;
import com.example.DTOProject.Repository.UserRepo;
import com.example.DTOProject.Service.UserService;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void registerUser(UserRequest dto) {
        // Convert DTO to entity
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole("USER"); // Default role
        userRepo.save(user);
        
    }

    @Override
    public UserResponse getUserById(int id) {
        // Find user by ID
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        // Return data as UserResponse
        return new UserResponse(user.getName(), user.getEmail());
    }
    }