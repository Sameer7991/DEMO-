package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailDTO {
    private String to;
    private String subject;
    private String body;

    // Getters and Setters
}

