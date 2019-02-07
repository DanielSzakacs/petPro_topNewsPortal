package com.codecool.petproject.newspostal.controller;

import com.codecool.petproject.newspostal.service.NewsFactory;
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
        try {
            return String.valueOf(newsFactory.getNews(source, type));
        } catch (Exception e) {
            e.printStackTrace();
            return "There is no data";
        }
    }

    @GetMapping("/topnews")
    public String getAllNews() {
        try {
            return String.valueOf(newsFactory.getNews("cnn", ""));
        } catch (Exception e) {
            e.printStackTrace();
            return "There is no data";
        }
    }
}
