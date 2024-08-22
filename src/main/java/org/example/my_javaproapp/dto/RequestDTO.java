package org.example.my_javaproapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private String question;
    private String answer;
    private String topic;
    private String difficultyLevel;
}
