package com.quiz.Master.Quiz.controller;

import com.quiz.Master.Quiz.dto.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {

    private final String USERNAME = "user";
    private final String PASSWORD = "password";

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        if ((USERNAME.equals(loginRequest.getUserName()) && PASSWORD.equals(loginRequest.getPassword()))){
            return "login successful";
        }else {
            return "invalid username or password";
        }
    }
}
