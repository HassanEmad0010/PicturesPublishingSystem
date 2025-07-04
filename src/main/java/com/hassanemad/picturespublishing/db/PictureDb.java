package com.hassanemad.picturespublishing.db;

import com.hassanemad.picturespublishing.entities.AdminEntity;
import com.hassanemad.picturespublishing.entities.PictureEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PictureDb {

   public  List<AdminEntity> adminEntities;
    public   List<PictureEntity> pictureEntities;

    public PictureDb() {
    adminEntities = new ArrayList<>();
    pictureEntities = new ArrayList<>();
    }
}
