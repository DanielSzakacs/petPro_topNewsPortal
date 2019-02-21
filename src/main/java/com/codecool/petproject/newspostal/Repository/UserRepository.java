package com.codecool.petproject.newspostal.Repository;

import com.codecool.petproject.newspostal.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepository extends JpaRepository<User, Long>{

    User getByEmail(String email);

    Boolean existsByEmail(String email);

    User findByEmail(String email);

}
