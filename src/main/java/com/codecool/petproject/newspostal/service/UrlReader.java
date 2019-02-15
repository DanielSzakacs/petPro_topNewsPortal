package com.codecool.petproject.newspostal.service;
import org.springframework.web.client.RestTemplate;

public class UrlReader {

    public  String getNewsFromApi(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}
