package com.example.CES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCardRepository extends JpaRepository<PaymentCard, Integer> {
    PaymentCard findByCardNumber(int cardNumber);
}