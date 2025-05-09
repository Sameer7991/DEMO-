package com.example.Stud.TeachWork.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Stud.TeachWork.Enum.Status;
import com.example.Stud.TeachWork.ResponseData.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j  // Lombok annotation to create Logger instance automatically
public class GlobalExceptionHandler {

    private ApiResponse<List<String>> buildApiResponse(
            int code,
            Status status,
            String message,
            List<String> data,
            String path,
            LocalDateTime timestamp) {
        
        return new ApiResponse<>(
                code,
                status,
                message,
                data,
                path,
                timestamp
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<String>>> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .collect(Collectors.toList());

        log.error("Validation error at [{}]: {}", request.getRequestURI(), errors);  // Logging

        return new ResponseEntity<>(
                buildApiResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        Status.FAIL,
                        "Validation failed",
                        errors,
                        request.getRequestURI(),
                        LocalDateTime.now()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<List<String>>> handleIllegalArgument(
            IllegalArgumentException ex,
            HttpServletRequest request) {

        log.error("Business validation failed at [{}]: {}", request.getRequestURI(), ex.getMessage());  // Logging

        return new ResponseEntity<>(
                buildApiResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        Status.FAIL,
                        "Business validation failed",
                        List.of(ex.getMessage()),
                        request.getRequestURI(),
                        LocalDateTime.now()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<List<String>>> handleUnexpectedException(
            Exception ex,
            HttpServletRequest request) {

        log.error("Unexpected error at [{}]: ", request.getRequestURI(), ex);  // Full stack trace logging

        return new ResponseEntity<>(
                buildApiResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        Status.ERROR,
                        "Unexpected error occurred",
                        List.of("Something went wrong"),
                        request.getRequestURI(),
                        LocalDateTime.now()
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<List<String>>> handleRuntimeException(
            RuntimeException ex,
            HttpServletRequest request) {

        log.error("Runtime error at [{}]: {}", request.getRequestURI(), ex.getMessage());  // Logging

        return new ResponseEntity<>(
                buildApiResponse(
                        HttpStatus.NOT_FOUND.value(),
                        Status.FAIL,
                        ex.getMessage(),
                        List.of(ex.getMessage()),
                        request.getRequestURI(),
                        LocalDateTime.now()
                ),
                HttpStatus.NOT_FOUND
        );
    }
}
