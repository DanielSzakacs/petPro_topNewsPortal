package com.codecool.petproject.newspostal.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public double id;

    public String email;

    public String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
