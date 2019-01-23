package com.codecool.petproject.newspostal.service;
import org.json.JSONObject;

public class NewsFactory {

    public Object getNews(String channelName, String newsType) throws Exception {
        return buildNews(channelName, newsType);
    }

    private Object buildNews(String channelName, String newsType) throws Exception{
        Object newsObject = getNewsApiRead(channelName, newsType).get("articles");
        return newsObject;
    }

    private JSONObject getNewsApiRead(String channelName, String newsType) throws Exception {
        String type;
        type = newsType.equals("top") ? "top-headlines" : "everything";
        String url = "https://newsapi.org/v2/"+ type +"?sources=" + channelName + "&apiKey=707805dad8ed44f1b6c24adb59e2739c";
        return UrlReader.getJsonObjectFromUrl(url);
    }
}
