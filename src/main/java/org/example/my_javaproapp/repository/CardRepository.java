package org.example.my_javaproapp.repository;

import org.example.my_javaproapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

  boolean deleteByCardId(Long id);

    Optional<Card> findByQuestion(String question);

    List<Card> findByTopic(String topic);

    List<Card> findByDifficultyLevel(String difficultyLevel);

}
