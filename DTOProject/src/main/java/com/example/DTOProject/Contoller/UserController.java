package com.example.DTOProject.Contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.DTOProject.DTO.UserRequest;
import com.example.DTOProject.DTO.UserResponse;
import com.example.DTOProject.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST request to register user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser( @RequestBody UserRequest userRequest) {
        userService.registerUser(userRequest);
        return ResponseEntity.ok("User registered successfully!");
    }

    // GET request to get user profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
    	UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }
}