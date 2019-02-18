package com.codecool.petproject.newspostal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepository extends JpaRepository<Integer, String>{


}
