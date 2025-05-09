package com.example.Stud.TeachWork.controllers;

import com.example.Stud.TeachWork.DTO.UserProfileDto;
import com.example.Stud.TeachWork.DTO.UserRegistrationDto;
import com.example.Stud.TeachWork.ResponseData.ApiResponse;
import com.example.Stud.TeachWork.serviceInterface.UserServiceInterface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserProfileDto>> registerUser(@RequestBody @Valid UserRegistrationDto dto, HttpServletRequest request) {
        log.info("Received registration request for email: {}", dto.getEmail());

        ResponseEntity<ApiResponse<UserProfileDto>> response = userService.registerUser(dto, request);

        log.info("Registration successful for email: {}", dto.getEmail());
        return response;
    }
    @PostMapping("/bulk-register")
    public ResponseEntity<ApiResponse<List<UserProfileDto>>> registerUsersIndividually(
            @RequestBody List<UserRegistrationDto> dtos,
            HttpServletRequest request) {

        return userService.registerUsersIndividually(dtos, request);
    }
    @PostMapping("/bulk-registers")
    public ResponseEntity<ApiResponse<Map<String, List<?>>>> registerUsersIndividually1(
            @RequestBody List<UserRegistrationDto> dtos,
            HttpServletRequest request) {

        return userService.registerUsersIndividually1(dtos, request); // Make sure this returns correct type
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserProfileDto>> getUserById(@PathVariable int id) {
        log.info("Received request to get user by ID: {}", id);

        ResponseEntity<ApiResponse<UserProfileDto>> response = userService.getUserById(id);

        log.info("Successfully fetched user details for ID: {}", id);
        return response;
    } @GetMapping
    public ResponseEntity<ApiResponse<List<UserProfileDto>>> getAllUsers(HttpServletRequest request) {
        return userService.getAllUsers(request);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable int id, HttpServletRequest request) {
        return userService.deleteUserById(id, request);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<ApiResponse<UserProfileDto>> updateUser(
            @PathVariable int id,
            @RequestBody UserRegistrationDto dto,
            HttpServletRequest request) {
        return userService.updateUserById(id, dto, request);
    }

}
