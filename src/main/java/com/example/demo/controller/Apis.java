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

    @PostMapping("/signup")
    public String signup(@RequestBody User user){
        User user1 = new User(user.getLogin(), user.getPassword());
        return userService.createUser(user1);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.login(user.getLogin(), user.getPassword());
    }

    @PostMapping("/ask")
    public String ask(@RequestBody Question question){
        Question q = new Question(question.getQuestion(), question.getUserid());
        questionService.createQuestion(q);
        return "Question created";
    }
    @GetMapping("myquestions/{id}")
    public List<Question> myQuestions(@PathVariable(value = "id") Long userid){
        return questionService.usersQuestions(userid);
    }
}
