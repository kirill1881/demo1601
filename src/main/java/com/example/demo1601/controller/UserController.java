package com.example.demo1601.controller;

import com.example.demo1601.models.UserModel;
import com.example.demo1601.repos.UserRepository;
import com.example.demo1601.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public boolean createUser(@RequestParam String login,
                              @RequestParam String password,
                              @RequestParam String name,
                              @RequestParam String lastName,
                              @RequestParam String mainPhoto,
                              @RequestParam String disc){
        return userService.createUser(login, password,
                name, lastName, mainPhoto, disc);
    }
    @PostMapping("/login")
    public UserModel login(@RequestParam String login,
                           @RequestParam String password){
        return userService.login(login, password);
    }
    @GetMapping("/getById/{id}")
    public UserModel getById(@PathVariable long id){
        return userRepository.findById(id);
    }

    @GetMapping("/getByLogin/{login}")
    public UserModel getByLogin(@PathVariable String login){
        return userRepository.findUserModelByLogin(login);
    }

    @PostMapping("/change")
    public void changeData(@RequestParam String name,
                           @RequestParam String lastName,
                           @RequestParam String disc,
                           @RequestParam String mainPhoto,
                           @RequestParam String login){
        userService.changeUser(name, lastName, disc, mainPhoto, login);
    }

}
