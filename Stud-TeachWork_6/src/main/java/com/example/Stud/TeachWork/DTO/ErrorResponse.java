package com.example.Stud.TeachWork.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String status;
    private int code;
    private String timestamp;
    private String message;
    private List<String> errors;
}
