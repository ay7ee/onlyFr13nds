package com.example.demo.repository;


import com.example.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Transactional
    @Query("Select new com.example.demo.model.Question(p.questionid, p.question, p.userid) from Question p WHERE p.userid = ?1")
    public List<Question> findByUserid(Long userid);

}
