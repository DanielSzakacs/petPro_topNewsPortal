package com.codecool.petproject.newspostal.service.login;

import com.codecool.petproject.newspostal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginHandler {

    @Autowired
    private UserRepository userRepository;

    public boolean isEmailRegistered(String email){
        return userRepository.getByEmail(email).email.equals(email);
    }

    //kell ami visszahesheli a kódot
    //kell a user kodot összeegyeztetti a kodal amit beirt. ha ok akkor uzenetet kuld vissza.
}
