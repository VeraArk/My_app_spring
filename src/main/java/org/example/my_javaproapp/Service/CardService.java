package org.example.my_javaproapp.Service;

import org.example.my_javaproapp.dto.RequestDTO;
import org.example.my_javaproapp.entity.Card;

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
