package com.hassanemad.picturespublishing.repos.user;

import com.hassanemad.picturespublishing.db.PictureDb;
import com.hassanemad.picturespublishing.entities.PictureEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UserRepo implements UserRepoInterface {

    private final PictureDb db ;
    public UserRepo( PictureDb db ) {
        this.db = db;
    }

    @Override
    public String savePic(PictureEntity pictureEntity) {
        db.pictureEntities.add(pictureEntity);
        return "Picture uploaded successfully id: "+ pictureEntity.getId();
    }

}
