package Service;

import dto.RequestDTO;
import entity.Card;
import repository.CardRepositoryMap;
import org.springframework.stereotype.Service;

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
    public Card save(RequestDTO request) {
        // Поиск карточки по вопросу (question)
        Optional<Card> existingCard = repository.findByQuestion(request.getQuestion());

        // Если карточка с таким вопросом существует
        if (existingCard.isPresent()) {
            Card updatedCard = existingCard.get();
            updatedCard.setAnswer(request.getAnswer());
            updatedCard.setTopic(request.getTopic());
            updatedCard.setDifficultyLevel(request.getDifficultyLevel());
            return repository.save(updatedCard);
        } else {
            // Если карточки с таким вопросом нет, создаем новую
            Card newCard = new Card();
            newCard.setQuestion(request.getQuestion());
            newCard.setAnswer(request.getAnswer());
            newCard.setTopic(request.getTopic());
            newCard.setDifficultyLevel(request.getDifficultyLevel());
            return repository.save(newCard);
        }
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
