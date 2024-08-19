package Repository;

import Entity.Card;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CardRepositoryMap implements CardRepository{


    private Map<Long, Card> database = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public List<Card> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<Card> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public Card save(Card card) {
        if (card.getId() == null) {
            card.setId(currentId++);
        }
       database.put(card.getId(), card);
        return card;
    }

    @Override
    public boolean deleteById(Long id) {
        return database.remove(id) != null;
    }

    @Override
    public List<Card> findByTopic(String topic) {
        return database.values().stream()
                .filter(client -> client.getTopic().equals(topic))
                .toList();
    }

    @Override
    public List<Card> findByDifficultyLevel(String difficultyLevel) {
        return database.values().stream()
                .filter(client -> client.getDifficultyLevel().equals(difficultyLevel))
                .toList();
    }
}
