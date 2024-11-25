package com.example.cashcard;

import jakarta.persistence.Id;

record CashCardRecord(@Id Long id, Double amount) {
}
