package com.example.cashcard.service;

import com.example.cashcard.entity.CashCard;
import com.example.cashcard.repository.CashCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashCardService {

    private final CashCardRepository repository;

    public CashCardService(CashCardRepository repository) {
        this.repository = repository;
    }

    public Optional<CashCard> findById(Long id) {
        return repository.findById(id);
    }

    public CashCard save(CashCard cashCard) {
        return repository.save(cashCard);
    }

    public Iterable<CashCard> findAll() {
        return repository.findAll();
    }
}