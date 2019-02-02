package com.codecool.petproject.newspostal.service;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlReader {

    protected static String getNewsFromApi(String url)
    {
        final String uri = url;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}
