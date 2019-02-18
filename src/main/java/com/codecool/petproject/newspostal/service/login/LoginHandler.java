package com.codecool.petproject.newspostal.service.login;

import com.codecool.petproject.newspostal.Repository.UserRepository;
import com.codecool.petproject.newspostal.service.security.BCryptPasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.InvalidAlgorithmParameterException;

public class LoginHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordHandler bCryptPasswordHandler;

    // TODO ez a fő method
    public boolean isUserEmailAndPasswordCorrect(String email, String password) {
        if(isEmailRegistered(email)){
            if(isPasswordCorrect(email, password)){
                return true;
            }else{
                new Exception("Your password is not correct");
            }
        }else{
            new InvalidAlgorithmParameterException("Your email is not correct");
        }
        return false;
    }

    private boolean isEmailRegistered(String email){
        return userRepository.getByEmail(email).email.equals(email);
    }

    private boolean isPasswordCorrect(String email, String password){
        String userHashedPassword = userRepository.getByEmail(email).password;
        return bCryptPasswordHandler.matchPasswords(password, userHashedPassword);
    }

    //kell ami visszahesheli a kódot
    //kell a user kodot összeegyeztetti a kodal amit beirt. ha ok akkor uzenetet kuld vissza.
}
