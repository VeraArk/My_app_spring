package Controller;

import Entity.Card;
import Service.CardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/cards")

public class CardController {

    private final CardServiceImpl cardServiceImpl;

    @GetMapping
    public String Print(){
        return "Hello world";
    }

    @GetMapping("/cards")
    public List<Card> findAllCards() {

        System.out.println("запустили findAll");
        return cardServiceImpl.findAll();
    }

    // localhost:8080/cards/id
    @GetMapping("/{id}")
    public Optional<Card> findById(@PathVariable Long id) {
        return cardServiceImpl.findById(id);
    }

    @PostMapping
    public Card addNew(@RequestBody Card card) {
        return cardServiceImpl.save(card);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return cardServiceImpl.deleteById(id);
    }

    //localhost:8080/cards/findByTopic/PastPerfect
    @GetMapping("/findByTopic/{topic}")
    public List<Card> findByTopic(@PathVariable String topic) {
        return cardServiceImpl.findByTopic(topic);
    }

    //localhost:8080/cards/findByDifficultyLevel?difficultyLevel=B1
    @GetMapping("/findByDifficultyLevel")
    public List<Card> findByDifficultyLevel(@RequestParam String difficultyLevel) {
        return cardServiceImpl.findByDifficultyLevel(difficultyLevel);
    }
}

