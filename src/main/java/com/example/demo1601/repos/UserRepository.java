package com.example.demo1601.repos;

import com.example.demo1601.models.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findUserModelByLogin(String login);
    UserModel findUserModelByLoginAndPassword(String login, String password);
    UserModel findById(long id);
}
