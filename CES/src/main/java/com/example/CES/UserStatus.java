package com.example.CES;

import jakarta.persistence.*;

@Entity
@Table (name = "UserStatus")
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserStatusID")
    private int id;



    @Column(name = "UserStatus")
    private String userStatus;

    public int getId() {
        return id;
    }

    public String getUserStatus() {
        return userStatus;
    }



}
