package com.codecool.petproject.newspostal.controller;

import com.codecool.petproject.newspostal.service.newsHandler.NewsFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RestControllerService {

    private NewsFactory newsFactory = new NewsFactory();

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
}
