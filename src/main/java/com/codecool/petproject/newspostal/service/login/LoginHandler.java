package com.codecool.petproject.newspostal.service.login;

import com.codecool.petproject.newspostal.Repository.UserRepository;
import com.codecool.petproject.newspostal.module.User;
import com.codecool.petproject.newspostal.service.security.BCryptPasswordHandler;

import java.security.InvalidAlgorithmParameterException;

public class LoginHandler {

    public BCryptPasswordHandler bCryptPasswordHandler;

    public LoginHandler(){};

    public LoginHandler(BCryptPasswordHandler bCryptPasswordHandler) {
        this.bCryptPasswordHandler = bCryptPasswordHandler;
    }

    // TODO ez a fő method
    public boolean isUserEmailAndPasswordCorrect(String email, String password, UserRepository userRepository) {
        if(isEmailRegistered(email, userRepository)){
            return isPasswordCorrect(email, password, userRepository);
        }else{
            new InvalidAlgorithmParameterException("Your email is not correct");
        }
        return false;
    }

    public boolean isEmailRegistered(String email, UserRepository userRepository){
        return userRepository.existsByEmail(email);
    }

    public boolean isPasswordCorrect(String email, String password, UserRepository userRepository){
        User user = userRepository.findByEmail(email);
        String userHashedPassword = user.password;
        boolean result =  bCryptPasswordHandler.matchPasswords(password, userHashedPassword);
        return result;
    }

}
