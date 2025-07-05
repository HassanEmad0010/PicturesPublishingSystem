package com.hassanemad.picturespublishing.services.admin;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;

import java.util.List;

public interface AdminServiceInterface {
    AdminDto login(AdminDto adminDto, String password);

}