package com.codecool.petproject.newspostal;

import com.codecool.petproject.newspostal.controller.RestControllerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestControllerTest {

    @Autowired
    private RestControllerService restControllerService;

    @Test
    public void restControllerService_endpoint_getAllNews_runWithoutException(){
        Assert.assertNotNull(this.restControllerService.getAllNews());
    }

    @Test
    public void restControllerService_endpoint_getNewsBySourceMethod_runWithOutExeption(){
        Assert.assertNotNull(this.restControllerService.getNewsBySource("cnn","top"));
    }

    @Test
    public void restControllerService_endpoint_getNewsBySourceMethod_willReturnException(){
        Assert.assertNotNull(this.restControllerService.getNewsBySource("cnn","nothing"));
    }

}
