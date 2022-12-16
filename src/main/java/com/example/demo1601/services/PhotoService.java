package com.example.demo1601.services;

import com.example.demo1601.models.PhotoModel;
import com.example.demo1601.models.helpers.PhotoToAppModel;
import com.example.demo1601.repos.PhotoRepository;
import com.example.demo1601.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;

    public PhotoService(PhotoRepository photoRepository, UserRepository userRepository) {
        this.photoRepository = photoRepository;
        this.userRepository = userRepository;
    }

    public void addPhoto(String url, String disc,
                         String login){
        PhotoModel photoModel = new PhotoModel();
        photoModel.setDisc(disc);
        photoModel.setUrl(url);
        photoModel.setAuthorId(userRepository.findUserModelByLogin(login).getId());
        photoRepository.save(photoModel);
    }

    public List<PhotoToAppModel> feed(){
        long number = photoRepository.count();
        System.out.println(number);
        Set<Long> set = new HashSet<>();
        int countFin = 0;
        if (number<20){
            countFin = (int) number;
        }else {
            countFin = 20;
        }
        while (set.size()!=countFin){
            set.add(new Random().nextLong(number+1));
        }
        List<Optional<PhotoModel>> list = new ArrayList<>();
        for (int i = 0; i < countFin; i++) {
            try {
                Optional<PhotoModel> photoModel = photoRepository.findById(set.stream().toList().get(i));
                list.add(photoModel);
                System.out.println(photoModel);
            }catch (Exception e){
                list.add(Optional.of(new PhotoModel()));
            }
        }
        List<PhotoToAppModel> photoToAppModels = new ArrayList<>();

        for (Optional<PhotoModel> p: list){
            PhotoToAppModel photo = new PhotoToAppModel(p.orElse(new PhotoModel()));
            photo.setName(userRepository.findById(p.get().getId()).getName()+
                    userRepository.findById(p.get().getId()).getLastName());
            photoToAppModels.add(photo);
        }
        return photoToAppModels;

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
