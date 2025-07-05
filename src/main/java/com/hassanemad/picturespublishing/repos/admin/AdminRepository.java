package com.hassanemad.picturespublishing.repos.admin;

import com.hassanemad.picturespublishing.db.AdminDb;
import com.hassanemad.picturespublishing.db.PictureDb;
import com.hassanemad.picturespublishing.entities.AdminEntity;
import com.hassanemad.picturespublishing.entities.PictureEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class AdminRepository implements AdminRepositoryInterface {

    private final PictureDb picturesDb;
    private final AdminDb adminDb;

    public AdminRepository( PictureDb picturesDb, AdminDb adminDb) {
        this.picturesDb = picturesDb;
        this.adminDb = adminDb;
        AdminEntity adminEntity = new AdminEntity("admin","admin123", false);
        adminDb.adminEntities.add(adminEntity);
    }



    @Override
    public boolean getPicStatus(String picId) {
        return false;
    }

    @Override
    public PictureEntity updatePicStatus(String picId, boolean status) {
     PictureEntity pic =   picturesDb.pictureEntities.stream().filter(pictureEntity ->
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
    public PictureEntity getPicDetails(String picId) {
        return picturesDb.pictureEntities.stream().filter(pictureEntity -> pictureEntity.getId().
                equals(picId)).findFirst().
                orElse(null);
    }

    @Override
    public List<PictureEntity> listUploadedPics() {
        return picturesDb.pictureEntities.stream().filter(pictureEntity -> pictureEntity.getPicStatus().equals("uploaded")).toList();
    }

    @Override
    public AdminEntity login(AdminEntity adminEntity) {
        if ( adminDb.adminEntities.get(0).getUsername().equals(adminEntity.getUsername())
                && adminDb.adminEntities.get(0).getPassword().equals(adminEntity.getPassword()) ) {
            adminEntity.setLoggedIn(true);
            return adminEntity;
        }
        return adminEntity;
    }

    @Override
    public PictureEntity createPicUrl(PictureEntity pictureEntity) {
        pictureEntity.setUrl("D/pics/"+pictureEntity.getId());
        return pictureEntity;
    }

    @Override
    public boolean deletePic(String picId) {
        return picturesDb.pictureEntities.removeIf(pictureEntity -> pictureEntity.getId().equals(picId));
    }
}
