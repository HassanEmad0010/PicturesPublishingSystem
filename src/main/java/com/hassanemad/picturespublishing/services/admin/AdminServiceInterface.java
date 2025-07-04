package com.hassanemad.picturespublishing.services.admin;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.PictureEntity;

import java.util.List;

public interface AdminServiceInterface {
    PictureEntity processPic(String picId, boolean response);
    PictureDto getPicDetails(String picId);
    List<PictureEntity> listUploadedPics();
    AdminDto login(AdminDto adminDto, String password);

}