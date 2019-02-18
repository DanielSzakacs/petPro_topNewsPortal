package com.codecool.petproject.newspostal.service.registration;

import com.codecool.petproject.newspostal.Repository.UserRepository;
import com.codecool.petproject.newspostal.module.User;
import com.codecool.petproject.newspostal.service.security.BCryptPasswordHandler;
import org.springframework.stereotype.Service;

@Service
public class RegistrationHandler {


    private BCryptPasswordHandler bCryptPasswordHandler = new BCryptPasswordHandler();

    public boolean saveNewUser(String email, String password, UserRepository userRepository) throws IllegalArgumentException{
        if(!isEmailInUse(email, userRepository)){
            String hashedCode = bCryptPasswordHandler.hashingCode(password);
            addUserToDB(email, hashedCode, userRepository);
            return true;
        }else{
            return false;
        }
    }

    private boolean isEmailInUse(String email, UserRepository userRepository){
        try{
            return userRepository.getByEmail(email).email.equals(email);
        }catch (NullPointerException e){
            return false;
        }
    }

    private void addUserToDB(String email, String password, UserRepository userRepository){
        userRepository.save(new User(email, password));
    }
}
