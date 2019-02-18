package com.codecool.petproject.newspostal;

import com.codecool.petproject.newspostal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewspostalApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewspostalApplication.class, args);
    }

}

