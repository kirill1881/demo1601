package com.example.demo1601.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @GetMapping
    public String a(){
        return "111";
    }
}
