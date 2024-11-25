    package com.example.cashcard.controller;

    import com.example.cashcard.entity.CashCard;
    import com.example.cashcard.service.CashCardService;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.util.UriComponentsBuilder;

    import java.net.URI;
    import java.util.Optional;


    @RestController
    public class CashCardController {

        private final CashCardService service;


        private CashCardController(CashCardService service) {
            this.service = service;

        }

        @GetMapping()
        private ResponseEntity<Iterable<CashCard>> findAll() {
            return ResponseEntity.ok(service.findAll());
        }

        @GetMapping("/cashcards/{requestedId}")
        private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {

            Optional<CashCard> optCashCard = service.findById(requestedId);
            if(optCashCard.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(optCashCard.get());
        }

        @GetMapping("/cashcards")
        private ResponseEntity<Iterable<CashCard>> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
            return ResponseEntity.ok(service.findAll());
        }

        @PostMapping("/cashcards")
        private ResponseEntity<Void> createCashCard(@RequestBody CashCard newCashCardRequest, UriComponentsBuilder ucb) {

            CashCard savedCashCard = service.save(newCashCardRequest);
            URI locationOfNewCashCard = ucb
                    .path("cashcards/{id}")
                    .buildAndExpand(savedCashCard.getId())
                    .toUri();

            return ResponseEntity.created(locationOfNewCashCard).build();
        }




    }