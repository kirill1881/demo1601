package com.example.demo1601.models.helpers;

import com.example.demo1601.models.PhotoModel;
import lombok.Data;

@Data
public class PhotoToAppModel {
    private String disc;
    private String url;
    private String name;

    public PhotoToAppModel(PhotoModel photoModel) {
        this.disc = photoModel.getDisc();
        this.url = photoModel.getUrl();
    }
}
