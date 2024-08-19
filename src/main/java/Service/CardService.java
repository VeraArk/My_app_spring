package Service;

import dto.RequestDTO;
import entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {

    List<Card> findAll();

    Optional<Card> findById(Long id);

    Card save(RequestDTO requestDTO);

    boolean deleteById(Long id);

    List<Card> findByTopic(String topic);

    List<Card> findByDifficultyLevel(String difficultyLevel);

}
