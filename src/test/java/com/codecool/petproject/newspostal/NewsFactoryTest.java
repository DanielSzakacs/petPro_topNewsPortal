package com.codecool.petproject.newspostal;

import com.codecool.petproject.newspostal.service.NewsFactory;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsFactoryTest {

    @Autowired
    NewsFactory newsFactory;

    @Test
    public void NewsFactory_getNewsMethod_wontReturn_runWithOutException() throws JSONException {
        Assert.assertNotNull(this.newsFactory.getNews("cnn", "top"));
    }


}
