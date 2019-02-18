package com.codecool.petproject.newspostal.service.registration;

import com.codecool.petproject.newspostal.Repository.UserRepository;
import com.codecool.petproject.newspostal.module.User;
import com.codecool.petproject.newspostal.service.security.BCryptPasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordHandler bCryptPasswordHandler;

    public void saveNewUser(String email, String password) throws IllegalArgumentException{
        if(isEmailInUse(email)){
            String hashedCode = bCryptPasswordHandler.hashCode(password);
            addUserToDB(email, hashedCode);
        }else{
            new IllegalArgumentException();
        }
    }

    public boolean isEmailInUse(String email){
        return userRepository.getByEmail(email).email.equals(email);
    }

    public void addUserToDB(String email, String password){
        userRepository.save(new User(email, password));
    }
    //Code hashelése
    //egy ok visszakuldése.
}
