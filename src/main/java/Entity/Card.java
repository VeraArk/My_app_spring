package Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Card {
    private Long id;

    private String question;
    private String answer;
    private String topic;
    private String difficultyLevel;

}
