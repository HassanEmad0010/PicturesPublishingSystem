package com.hassanemad.picturespublishing.services.admin;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Admin;
import com.hassanemad.picturespublishing.entities.Picture;

import java.util.List;
import java.util.Optional;

public interface AdminServiceInterface {
    AdminDto login(AdminDto adminDto, String password);
    public void loggOutAdminsSession() ;
    public Admin getAdmin (String userName, String password);

}