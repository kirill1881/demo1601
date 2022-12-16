package com.example.demo1601.controller;

import com.example.demo1601.models.PhotoModel;
import com.example.demo1601.models.helpers.PhotoToAppModel;
import com.example.demo1601.repos.UserRepository;
import com.example.demo1601.services.PhotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/photos")
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/feed")
    public List<PhotoToAppModel> getFeed(){
        return photoService.feed();
    }

    @PostMapping("/add")
    public void addPhoto(@RequestParam String disc,
                         @RequestParam String url,
                         @RequestParam String login){
        photoService.addPhoto(url, disc, login);
    }

}
