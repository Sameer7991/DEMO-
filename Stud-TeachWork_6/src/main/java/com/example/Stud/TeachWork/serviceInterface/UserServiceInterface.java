package com.example.Stud.TeachWork.serviceInterface;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.Stud.TeachWork.DTO.UserProfileDto;
import com.example.Stud.TeachWork.DTO.UserRegistrationDto;
import com.example.Stud.TeachWork.ResponseData.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;

public interface UserServiceInterface {
	
	
	ResponseEntity<ApiResponse<UserProfileDto>> registerUser(UserRegistrationDto dto, HttpServletRequest request);
	ResponseEntity<ApiResponse<UserProfileDto>> getUserById(int id);
	ResponseEntity<ApiResponse<List<UserProfileDto>>> registerUsersIndividually(
	        List<UserRegistrationDto> dtos,
	        HttpServletRequest request
	    );
	ResponseEntity<ApiResponse<Map<String, List<?>>>> registerUsersIndividually1(
	        List<UserRegistrationDto> dtos,
	        HttpServletRequest request);
	ResponseEntity<ApiResponse<List<UserProfileDto>>> getAllUsers(HttpServletRequest request);
	ResponseEntity<ApiResponse<String>> deleteUserById(int id, HttpServletRequest request) ; 
	ResponseEntity<ApiResponse<UserProfileDto>> updateUserById(int id, UserRegistrationDto dto, HttpServletRequest request);
}
	

	    






