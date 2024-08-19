package Service;

import Entity.Card;
import Repository.CardRepositoryMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    // private List<Card> cards = new ArrayList<>();

    private CardRepositoryMap repository;

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Card> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Card save(Card card) {
        if (card.getId() != null) {
            Optional<Card> existingCard = repository.findById(card.getId());
            if (existingCard.isPresent()) {
                Card updatedCard = existingCard.get();
                updatedCard.setQuestion(card.getQuestion());
                updatedCard.setAnswer(card.getAnswer());
                updatedCard.setTopic(card.getTopic());
                updatedCard.setDifficultyLevel(card.getDifficultyLevel());
                return repository.save(updatedCard);
            }
        }
        return repository.save(card);
    }

    @Override
    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public List<Card> findByTopic(String topic) {
        return repository.findByTopic(topic);
    }

    @Override
    public List<Card> findByDifficultyLevel(String difficultyLevel) {
        return repository.findByDifficultyLevel(difficultyLevel);
    }
}
