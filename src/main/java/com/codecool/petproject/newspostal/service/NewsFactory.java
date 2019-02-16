package com.codecool.petproject.newspostal.service;

import org.json.JSONObject;

public class NewsFactory {

    public String getNews(String channelName, String newsType) {
        return jsonBuilder(channelName, newsType);
    }

    public String jsonBuilder(String channelName, String newsType) {
        JSONObject jsonNews = null;
        try {
            jsonNews = new JSONObject(getNewsByType(channelName, newsType));
            return  String.valueOf(jsonNews.get("articles")); // With this easier to manage, and no unnecessary data.
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getNewsByType(String channelName, String newsType) {
        String type;
        type = newsType.equals("top") ? "top-headlines" : "everything";
        String url = "https://newsapi.org/v2/"+ type +"?sources=" + channelName + "&apiKey=707805dad8ed44f1b6c24adb59e2739c";
        return new UrlReader().getNewsFromApi(url);
    }
}
