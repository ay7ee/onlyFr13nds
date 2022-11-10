package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean countUserByLoginAndPassword(String login, String password);

    public User findByLogin(String login);

    public User findByLoginAndPassword(String login, String password);
}
