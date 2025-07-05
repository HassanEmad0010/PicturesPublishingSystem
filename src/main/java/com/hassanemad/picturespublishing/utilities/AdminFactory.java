package com.hassanemad.picturespublishing.utilities;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.entities.Admin;

public class AdminFactory {

    public static Admin toAdminEntity(AdminDto adminDto, String password){
    return new Admin(adminDto.userName(),password, false);
    }

    public static AdminDto toAdminDto(Admin admin){
    return new AdminDto(admin.getUsername(), admin.isLoggedIn());
    }



}

