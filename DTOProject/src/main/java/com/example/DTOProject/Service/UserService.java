package com.example.DTOProject.Service;

import com.example.DTOProject.DTO.UserRequest;
import com.example.DTOProject.DTO.UserResponse;

public interface UserService {
	 void registerUser(UserRequest dto);

	 UserResponse getUserById(int id);

}