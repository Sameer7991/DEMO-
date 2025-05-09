package com.example.Stud.TeachWork.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Stud.TeachWork.DTO.UserProfileDto;
import com.example.Stud.TeachWork.DTO.UserRegistrationDto;
import com.example.Stud.TeachWork.Enum.Status;
import com.example.Stud.TeachWork.ResponseData.ApiResponse;
import com.example.Stud.TeachWork.entities.User;
import com.example.Stud.TeachWork.repo.UserRepo;
import com.example.Stud.TeachWork.serviceInterface.UserServiceInterface;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<ApiResponse<UserProfileDto>> registerUser(UserRegistrationDto dto, HttpServletRequest request) {
        log.info("Starting registerUser method for email: {}", dto.getEmail());

        // Check if the email already exists
        if (userRepo.existsByEmail(dto.getEmail())) {
            log.warn("Attempted registration with duplicate email: {}", dto.getEmail());
            throw new IllegalArgumentException("Email already registered");
        }

        // Create new User entity
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole("USER"); // Default role

        // Save the new user to the database
        User savedUser = userRepo.save(user);
        log.debug("User saved in database with ID: {}", savedUser.getId());

        // Prepare the response DTO
        UserProfileDto responseDto = new UserProfileDto(
                savedUser.getName(),
                savedUser.getEmail()
        );

        log.info("User registered successfully with email: {}", savedUser.getEmail());

        // Build the ApiResponse to return
        ApiResponse<UserProfileDto> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                Status.SUCCESS,
                "User registered successfully",
                responseDto,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<ApiResponse<UserProfileDto>> getUserById(int id) {
        log.info("Starting getUserById method for ID: {}", id);

        User user = userRepo.findById(id)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", id);
                    return new RuntimeException("User not found with ID: " + id);
                });

        // Prepare response DTO
        UserProfileDto responseDto = new UserProfileDto(
                user.getName(),
                user.getEmail()
        );

        log.info("User retrieved successfully with ID: {}", user.getId());

        // Build the ApiResponse to return
        ApiResponse<UserProfileDto> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                Status.SUCCESS,
                "User retrieved successfully",
                responseDto,
                "/users/" + id,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Override
    public ResponseEntity<ApiResponse<List<UserProfileDto>>> registerUsersIndividually(
            List<UserRegistrationDto> dtos,
            HttpServletRequest request) {

        log.info("Starting bulk user registration (individual saves)");

        List<UserProfileDto> registeredUsers = new ArrayList<>();

        for (UserRegistrationDto dto : dtos) {
            if (userRepo.existsByEmail(dto.getEmail())) {
                log.warn("Duplicate email found: {}", dto.getEmail());
                throw new IllegalArgumentException(  "some  email already registered"); 
                
            }

            User user = new User();
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setRole("USER");

            User savedUser = userRepo.save(user); // Save one by one

  registeredUsers.add(new UserProfileDto(  savedUser.getName(),savedUser.getEmail()));
        }

        ApiResponse<List<UserProfileDto>> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                Status.SUCCESS,
                "Users registered successfully",
                registeredUsers,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @Override
    public ResponseEntity<ApiResponse<Map<String, List<?>>>> registerUsersIndividually1(
            List<UserRegistrationDto> dtos,
            HttpServletRequest request) {

        List<UserProfileDto> successList = new ArrayList<>();
        List<Map<String, String>> failedList = new ArrayList<>();

        for (UserRegistrationDto dto : dtos) {
            if (userRepo.existsByEmail(dto.getEmail())) {
                // Email already exists → failed
                Map<String, String> error = new HashMap<>();
                error.put("email", dto.getEmail());
                error.put("error", "Email already registered");
                failedList.add(error);
            } else {
                // Save user → success
                User user = new User();
                user.setName(dto.getName());
                user.setEmail(dto.getEmail());
                user.setPassword(dto.getPassword());
                user.setRole("USER");

                User savedUser = userRepo.save(user);

                successList.add(new UserProfileDto(
                        savedUser.getName(), savedUser.getEmail()
                ));
            }
        }

        // Final result
        Map<String, List<?>> result = new HashMap<>();
        result.put("successful", successList);
        result.put("failed", failedList);

        ApiResponse<Map<String, List<?>>> response = new ApiResponse<>(
                207, // Partial success
                Status.SUCCESS,
                "Bulk registration completed",
                result,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(207).body(response);
    }
    @Override
    public ResponseEntity<ApiResponse<List<UserProfileDto>>> getAllUsers(HttpServletRequest request) {
        log.info("Fetching all users");

        try {
            List<User> users = userRepo.findAll();
            List<UserProfileDto> userDtos = new ArrayList<>();

            for (User user : users) {
                userDtos.add(new UserProfileDto(
                        user.getName(),
                        user.getEmail()
                ));
            }

            ApiResponse<List<UserProfileDto>> response = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    Status.SUCCESS,
                    "All users fetched successfully",
                    userDtos,
                    request.getRequestURI(),
                    LocalDateTime.now()
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("Error while fetching users: {}", e.getMessage(), e);

            ApiResponse<List<UserProfileDto>> errorResponse = new ApiResponse<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    Status.FAIL,
                    "Something went wrong while fetching users",
                    null,
                    request.getRequestURI(),
                    LocalDateTime.now()
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    @Override
    public ResponseEntity<ApiResponse<String>> deleteUserById(int id, HttpServletRequest request) {
        log.info("Deleting user with ID: {}", id);

        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        userRepo.delete(user);

        ApiResponse<String> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                Status.SUCCESS,
                "User deleted successfully",
                "Deleted user ID: " + id,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }
    @Override
    public ResponseEntity<ApiResponse<UserProfileDto>> updateUserById(int id, UserRegistrationDto dto, HttpServletRequest request) {
        log.info("Updating user with ID: {}", id);

        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        // Update user details
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());  // You might want to hash this password in a real app!

        User updatedUser = userRepo.save(user);

        // Prepare response DTOS
        UserProfileDto responseDto = new UserProfileDto(
                updatedUser.getName(),
                updatedUser.getEmail()
        );

        ApiResponse<UserProfileDto> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                Status.SUCCESS,
                "User updated successfully",
                responseDto,
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }




}
