package com.hassanemad.picturespublishing.repos.admin;

import com.hassanemad.picturespublishing.entities.AdminEntity;
import com.hassanemad.picturespublishing.entities.PictureEntity;

import java.util.List;

public interface AdminRepositoryInterface {
    boolean getPicStatus(String picId);
    PictureEntity updatePicStatus(String picId, boolean response);
    PictureEntity getPicDetails(String picId);
    List<PictureEntity> listUploadedPics();
    AdminEntity login(AdminEntity adminEntity);
    PictureEntity createPicUrl(PictureEntity pictureEntity);
    boolean deletePic(String picId);
}
