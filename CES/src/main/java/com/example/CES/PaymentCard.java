package com.example.CES;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PaymentCards")
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CardNumber")
    private int cardNumber;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User user;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "card_type")
    private String cardType;



}
