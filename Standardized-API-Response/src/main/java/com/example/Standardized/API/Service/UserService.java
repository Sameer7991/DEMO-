package com.example.Standardized.API.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.example.Standardized.API.DTO.ApiResponse;
import com.example.Standardized.API.DTO.UserRegister;
import com.example.Standardized.API.DTO.UserResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	
    ResponseEntity<ApiResponse<UserResponseDTO>> addUser(UserRegister dto, HttpServletRequest request);
    
    Page<UserResponseDTO> getUsers(Pageable pageable);
    
}
