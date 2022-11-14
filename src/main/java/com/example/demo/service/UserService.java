package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(User user) {
        if (userRepository.findByLogin(user.getLogin()) == null) {
            userRepository.save(user);
            return "created";
        }
        return "such user exists";
    }

    public String login(String login, String password){
        if(userRepository.findByLoginAndPassword(login, password) != null){

            return "" + userRepository.findByLoginAndPassword(login, password).getUserid();
        }
        else{
            return "Inccorrect password or login";
        }
    }

}
