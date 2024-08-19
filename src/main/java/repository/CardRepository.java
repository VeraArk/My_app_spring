package repository;

import entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardRepository {

    List<Card> findAll();

    Optional<Card> findById(Long id);

    Card save(Card card);

    boolean deleteById(Long id);

    Optional<Card> findByQuestion(String question);

    List<Card> findByTopic(String topic);

    List<Card> findByDifficultyLevel(String difficultyLevel);

}
