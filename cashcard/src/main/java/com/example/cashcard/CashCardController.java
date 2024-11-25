    package com.example.cashcard;

    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    class CashCardController {

            @GetMapping("/cashcards/{requestedId}")
            private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
                if (requestedId.equals( 99)) {
                    CashCard cashCard = new CashCard(1000L, 0.0);
                    return ResponseEntity.ok(cashCard);

                }
                return ResponseEntity.notFound().build();
            }
    }