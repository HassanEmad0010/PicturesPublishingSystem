package com.hassanemad.picturespublishing.repos.admin;

import com.hassanemad.picturespublishing.db.AdminDb;
import com.hassanemad.picturespublishing.db.PictureDb;
import com.hassanemad.picturespublishing.entities.Admin;
import com.hassanemad.picturespublishing.entities.Picture;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
@Deprecated
@Component
@Primary
public class AdminRepository implements AdminRepositoryInterface {

    private final PictureDb picturesDb;
    private final AdminDb adminDb;

    public AdminRepository( PictureDb picturesDb, AdminDb adminDb) {
        this.picturesDb = picturesDb;
        this.adminDb = adminDb;
        Admin admin = new Admin("admin","admin123", false);
        adminDb.adminEntities.add(admin);
    }



    @Override
    public boolean getPicStatus(String picId) {
        return false;
    }

    @Override
    public Picture updatePicStatus(String picId, boolean status) {
     Picture pic =   picturesDb.pictureEntities.stream().filter(pictureEntity ->
                pictureEntity.getId().equals(picId)).findFirst().orElse(null);
     if (pic != null) {
         if (status ) {
             pic.setPicStatus("approved");
             pic.setUrl("D/pics/"+pic.getId());
             return pic;
         }
     }
        deletePic(picId);
        return null;
    }

    @Override
    public Picture getPicDetails(String picId) {
        return picturesDb.pictureEntities.stream().filter(pictureEntity -> pictureEntity.getId().
                equals(picId)).findFirst().
                orElse(null);
    }

    @Override
    public List<Picture> listUploadedPics() {
        return picturesDb.pictureEntities.stream().filter(pictureEntity -> pictureEntity.getPicStatus().equals("uploaded")).toList();
    }

    @Override
    public Admin login(Admin admin) {
        if ( adminDb.adminEntities.get(0).getUsername().equals(admin.getUsername())
                && adminDb.adminEntities.get(0).getPassword().equals(admin.getPassword()) ) {
            admin.setLoggedIn(true);
            return admin;
        }
        return admin;
    }

    @Override
    public Picture createPicUrl(Picture picture) {
        picture.setUrl("D/pics/"+ picture.getId());
        return picture;
    }

    @Override
    public boolean deletePic(String picId) {
        return picturesDb.pictureEntities.removeIf(pictureEntity -> pictureEntity.getId().equals(picId));
    }
}
