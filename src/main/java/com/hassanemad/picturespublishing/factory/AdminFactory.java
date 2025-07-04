package com.hassanemad.picturespublishing.factory;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.AdminEntity;
import com.hassanemad.picturespublishing.entities.PictureEntity;

import java.util.UUID;

public class AdminFactory {

    public static AdminEntity toAdminEntity(AdminDto adminDto, String password){
    return new AdminEntity(adminDto.userName(),password, false);
    }

    public static AdminDto toAdminDto(AdminEntity adminEntity){
    return new AdminDto(adminEntity.getUsername(), adminEntity.isLoggedIn());
    }



}

