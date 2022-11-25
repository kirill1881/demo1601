package com.example.demo1601.services;

import com.example.demo1601.models.PhotoModel;
import com.example.demo1601.repos.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void addPhoto(String url, String disc,
                         long id){
        PhotoModel photoModel = new PhotoModel();
        photoModel.setDisc(disc);
        photoModel.setUrl(url);
        photoModel.setAuthorId(id);
        photoRepository.save(photoModel);
    }

    public void deletePhoto(long id){
        photoRepository.deleteById(id);
    }

    public void edit(String disc, long id){
        PhotoModel photoModel = photoRepository.findById(id);
        photoModel.setDisc(disc);
        photoRepository.save(photoModel);
    }

    public PhotoModel getPhoto(long id){
        return photoRepository.findById(id);
    }

    public List<PhotoModel> getByUserId(long userId){
        return photoRepository.findAllByAuthorId(userId);
    }
}
