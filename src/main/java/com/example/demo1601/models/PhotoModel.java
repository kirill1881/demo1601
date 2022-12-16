package com.example.demo1601.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.File;

@Entity
@Data
@Table(name = "photo")
public class PhotoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "disc")
    String disc;

    @Column(name = "url")
    String url;

    @Column(name = "author_id")
    private long authorId;


}
