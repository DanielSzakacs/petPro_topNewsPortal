package com.codecool.petproject.newspostal;

import com.codecool.petproject.newspostal.service.NewsFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsFactoryTest {

    NewsFactory newsFactory;

    @Test
    public void setNewsFactory_jsonBuilderMethod_returnEmptyString(){
        newsFactory = new NewsFactory();
        assertEquals("",newsFactory.jsonBuilder("", ""));
    }

    @Test
    public void setNewsFactory_getNewsByType_willReturn10NewsIfTypeIsTop() throws JSONException { // TODO Balazs nézze meg
        newsFactory = new NewsFactory();
        JSONObject jsonNews = new JSONObject(newsFactory.getNewsByType("cnn", "top"));
        int result = (Integer) jsonNews.get("totalResults");
        assertEquals(10, result);
    }

    @Test
    public void setNewsFactory_getNewsByType_willReturn20NewsIfTypeIsAEmptyString() throws JSONException { // TODO Balazs nézze meg
        newsFactory = new NewsFactory();
        JSONObject jsonNews = new JSONObject(newsFactory.getNewsByType("cnn", ""));
        int result = (Integer) jsonNews.get("totalResults");
        System.out.println(jsonNews);
        assertTrue(result > 10);
    }
}
