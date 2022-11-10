package com.example.demo.service;


import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public String createQuestion(Question question){
        questionRepository.save(question);
        return "Question saved";
    }
    public List<Question> usersQuestions(Long id){
        return questionRepository.findByUserid(id);
    }
}
