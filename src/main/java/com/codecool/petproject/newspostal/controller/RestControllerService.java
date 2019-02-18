package com.codecool.petproject.newspostal.controller;

import com.codecool.petproject.newspostal.Repository.UserRepository;
import com.codecool.petproject.newspostal.service.login.LoginHandler;
import com.codecool.petproject.newspostal.service.newsHandler.NewsFactory;
import com.codecool.petproject.newspostal.service.registration.RegistrationHandler;
import com.codecool.petproject.newspostal.service.security.BCryptPasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@CrossOrigin
@RestController
public class RestControllerService {

    @Autowired
    public UserRepository userRepository;

    public BCryptPasswordHandler bCryptPasswordHandler = new BCryptPasswordHandler();

    private NewsFactory newsFactory = new NewsFactory();
    private RegistrationHandler registrationHandler = new RegistrationHandler();
    private LoginHandler loginHandler = new LoginHandler(bCryptPasswordHandler);


    @GetMapping("/topnews/{source}")
    public String getNewsBySource(@PathVariable String source, @RequestParam(name = "type", required = false) String type)  {
        if(source.equals("rt")){ //This part is necessary because other ways we get all the rt news which is on spanish.
            type = "top";
        }else{
            type = type == null ? "" : type;
        }
        return String.valueOf(newsFactory.getNews(source, type));
    }

    @GetMapping("/topnews")
    public String getAllNews() {
        return String.valueOf(newsFactory.getNews("cnn", ""));
    }


    @PostMapping("/registration/{useremail}")
    public ResponseEntity userRegistration(@PathVariable String useremail, @RequestParam(name = "userpassword", required = true) String userpassword){
        if(registrationHandler.saveNewUser(useremail, userpassword, userRepository)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login/{useremail}")
    public ResponseEntity userLogin(@PathVariable String useremail, @RequestParam(name = "userpassword", required = true) String userpassword){
        if(loginHandler.isUserEmailAndPasswordCorrect(useremail, userpassword, userRepository)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
