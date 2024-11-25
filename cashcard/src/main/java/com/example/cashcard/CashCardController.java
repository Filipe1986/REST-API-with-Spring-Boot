    package com.example.cashcard;

    import com.example.cashcard.repository.CashCardRepository;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.Optional;

    @RestController
    public class CashCardController {


        private final CashCardRepository cashCardRepository;

        private CashCardController(CashCardRepository cashCardRepository) {
            this.cashCardRepository = cashCardRepository;
        }


            @GetMapping("/cashcards/{requestedId}")
            private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {

                Optional<CashCard> cashcard = cashCardRepository.findById(requestedId);
                if(cashcard.isPresent()) {
                    return ResponseEntity.ok(cashcard.get());
                }
                return ResponseEntity.notFound().build();
            }
    }