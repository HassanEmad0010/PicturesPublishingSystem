package com.hassanemad.picturespublishing.utilities;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.entities.AdminEntity;

public class AdminFactory {

    public static AdminEntity toAdminEntity(AdminDto adminDto, String password){
    return new AdminEntity(adminDto.userName(),password, false);
    }

    public static AdminDto toAdminDto(AdminEntity adminEntity){
    return new AdminDto(adminEntity.getUsername(), adminEntity.isLoggedIn());
    }



}

