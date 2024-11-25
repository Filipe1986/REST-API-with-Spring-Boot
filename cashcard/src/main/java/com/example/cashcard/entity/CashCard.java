package com.example.cashcard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CashCard {
    @Id
    private Long id;

    private String owner;
    private Double balance;

    public CashCard() {
    }

    public CashCard(Long id, String owner, Double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }
}
