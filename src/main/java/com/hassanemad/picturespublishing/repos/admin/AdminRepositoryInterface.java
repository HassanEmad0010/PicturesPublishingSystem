package com.hassanemad.picturespublishing.repos.admin;

import com.hassanemad.picturespublishing.entities.Admin;
import com.hassanemad.picturespublishing.entities.Picture;

import java.util.List;

@Deprecated
public interface AdminRepositoryInterface {
    boolean getPicStatus(String picId);
    Picture updatePicStatus(String picId, boolean response);
    Picture getPicDetails(String picId);
    List<Picture> listUploadedPics();
    Admin login(Admin admin);
    Picture createPicUrl(Picture picture);
    boolean deletePic(String picId);
}
