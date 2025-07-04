package com.hassanemad.picturespublishing.services.admin;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.PictureEntity;
import com.hassanemad.picturespublishing.repos.admin.AdminRepository;

import com.hassanemad.picturespublishing.repos.admin.AdminRepositoryInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.hassanemad.picturespublishing.factory.AdminFactory.*;
import static com.hassanemad.picturespublishing.factory.PictureFactory.toPictureDto;

@Component
@Primary
public class AdminService implements AdminServiceInterface {
AdminRepositoryInterface adminRepositoryInterface;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepositoryInterface = adminRepository;

    }


    @Override
    public PictureEntity processPic(String picId, boolean status) {

        return adminRepositoryInterface.updatePicStatus(picId,status);

    }

    @Override
    public PictureDto getPicDetails(String picId) {
        return toPictureDto(adminRepositoryInterface.getPicDetails(picId));
    }

    @Override
    public List<PictureEntity> listUploadedPics() {
        return adminRepositoryInterface.listUploadedPics();
    }

    @Override
    public AdminDto login(AdminDto adminDto, String password) {
        return toAdminDto(adminRepositoryInterface.login(toAdminEntity(adminDto, password)));

    }

}
