package com.example.demo.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue
    private Long userid;
    private String login;
    private String password;

    public User(){
    }
    public User(Long userid, String login, String password) {
        this.userid = userid;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public User(String login) {
        this.login = login;
    }
}
