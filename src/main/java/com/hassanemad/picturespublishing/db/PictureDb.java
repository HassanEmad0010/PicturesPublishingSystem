package com.hassanemad.picturespublishing.db;

import com.hassanemad.picturespublishing.entities.Picture;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Deprecated

@Component
public class PictureDb {

    public List<Picture> pictureEntities;
    public PictureDb() {
    pictureEntities = new ArrayList<>();
    }
}
