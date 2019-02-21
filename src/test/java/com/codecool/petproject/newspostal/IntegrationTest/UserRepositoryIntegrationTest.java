//package com.codecool.petproject.newspostal.IntegrationTest;
//
//import com.codecool.petproject.newspostal.Repository.UserRepository;
//import com.codecool.petproject.newspostal.module.User;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static junit.framework.TestCase.assertTrue;
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserRepositoryIntegrationTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void findByEmail_return_theSavedUserEmail(){
//        User user = new User("mike@gmail.com", "password");
//        userRepository.save(user);
//
//        User foundUser = userRepository.findByEmail("mike@gmail.com");
//        assertEquals(foundUser.email, "mike@gmail.com");
//    }
//
//    @Test
//    public void existsByEmail_willReturnTrue(){
//        User user = new User("david@gmail.com", "password1");
//        userRepository.save(user);
//       assertTrue(userRepository.existsByEmail("david@gmail.com"));
//    }
//
//    @Test
//    public void getByEmail_willReturnTheRightUser(){
//        User user = new User("pety@freemail.com", "easyPassword");
//        userRepository.save(user);
//        Assert.assertEquals("easyPassword", user.password);
//    }
//}