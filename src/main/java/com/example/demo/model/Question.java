package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question{
    @Id
    @GeneratedValue
    private Long questionid;
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;
    private Long userid;

    public Question(String question, User user, Long userid) {
        this.question = question;
        this.user = user;
        this.userid = userid;
    }

    public Question(Long questionid, String question, User user, Long userid) {
        this.questionid = questionid;
        this.question = question;
        this.user = user;
        this.userid = userid;
    }

    public Question() {
    }

    public Question(String question, Long userid) {
        this.question = question;
        this.userid = userid;
    }

    public Question(Long questionid, String question, Long userid) {
        this.questionid = questionid;
        this.question = question;
        this.userid = userid;
    }
}
