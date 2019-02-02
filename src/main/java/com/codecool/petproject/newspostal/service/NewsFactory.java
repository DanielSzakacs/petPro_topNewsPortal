package com.codecool.petproject.newspostal.service;

import org.json.JSONException;
import org.json.JSONObject;

public class NewsFactory {

    public Object getNews(String channelName, String newsType) throws JSONException {
        return jsonBuilder(channelName, newsType);
    }

    private Object jsonBuilder(String channelName, String newsType) throws JSONException {
        JSONObject jsonNews = new JSONObject(getNewsByType(channelName, newsType));
        return jsonNews.get("articles"); // With this easier to manage, and no unnecessary data.
    }

    private String getNewsByType(String channelName, String newsType) {
        String type;
        type = newsType.equals("top") ? "top-headlines" : "everything";
        String url = "https://newsapi.org/v2/"+ type +"?sources=" + channelName + "&apiKey=707805dad8ed44f1b6c24adb59e2739c";
        return UrlReader.getNewsFromApi(url);
    }
}
