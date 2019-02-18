package com.codecool.petproject.newspostal.service.registration;

import com.codecool.petproject.newspostal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationHandler {

    @Autowired
    private UserRepository userRepository;
    //Ez ellenőrzi hogy az emil még nem használt.
    public boolean isEmailInUse(String email){
        return userRepository.getByEmail(email).email.equals(email);
    }

    //Code hashelése
    //egy ok visszakuldése.
}
