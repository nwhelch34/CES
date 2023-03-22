package com.example.CES;

import jakarta.persistence.*;

@Entity
@Table (name = "UserTypes")
public class UserTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserTypeID")
    private int id;



    @Column(name = "UserTypeName")
    private String userTypeName;

    public int getId() {
        return id;
    }

    public String getUserTypeName() {
        return userTypeName;
    }



}
