package com.example.demo.controller;


import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.service.QuestionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Apis {
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;

    @GetMapping("/signup")
    public String signup(String login , String password){
        User user = new User(login, password);
        return userService.createUser(user);
    }

    @GetMapping("/login")
    public String login(String login, String password){
        return userService.login(login, password);
    }

    @GetMapping("/ask")
    public String ask(String question, Long userid){
        Question q = new Question(question, userid);
        questionService.createQuestion(q);
        return "Question created";
    }
    @GetMapping("myquestions/{id}")
    public List<Question> myQuestions(@PathVariable(value = "id") Long userid){
        return questionService.usersQuestions(userid);
    }


}
