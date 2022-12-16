package com.example.demo1601.services;

import com.example.demo1601.models.UserModel;
import com.example.demo1601.repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean createUser(String login, String password,
                              String name, String lastName,
                              String mainPhoto){
        UserModel userModel;
        userModel = userRepository.findUserModelByLogin(login);
        if (userModel!=null){
            return false;
        }
        userModel = new UserModel();
        userModel.setLogin(login);
        userModel.setName(name);
        userModel.setPassword(password);
        userModel.setLastName(lastName);
        userModel.setMainPhoto(mainPhoto);

        userRepository.save(userModel);
        return true;
    }

    public UserModel login(String login, String password){
        UserModel userModel;
        return userRepository.findUserModelByLoginAndPassword(login, password);
    }

    public void changeUser(String name, String lastName, String disc,
                           String photo, String login){
        UserModel userModel = userRepository.findUserModelByLogin(login);
        userModel.setDisc(disc);
        userModel.setMainPhoto(photo);
        userModel.setName(name);
        userModel.setLastName(lastName);

        userRepository.save(userModel);
    }
}
