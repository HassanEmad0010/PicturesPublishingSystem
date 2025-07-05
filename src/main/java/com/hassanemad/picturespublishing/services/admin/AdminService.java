package com.hassanemad.picturespublishing.services.admin;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Admin;
import com.hassanemad.picturespublishing.entities.Picture;
import com.hassanemad.picturespublishing.repos.admin.AdminRepoJpa;
import com.hassanemad.picturespublishing.repos.admin.AdminRepository;

import com.hassanemad.picturespublishing.repos.admin.AdminRepositoryInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.hassanemad.picturespublishing.utilities.AdminFactory.*;
import static com.hassanemad.picturespublishing.utilities.PictureFactory.toPictureDto;

@Component
@Primary
public class AdminService implements AdminServiceInterface {
AdminRepoJpa adminRepoJpa;

    public AdminService(AdminRepoJpa adminRepoJpa) {
        this.adminRepoJpa = adminRepoJpa;

    }

    @Override
    public AdminDto login(AdminDto adminDto, String password) {
       Optional<Admin> adminFound= adminRepoJpa.
               findByUsernameAndPassword(adminDto.userName(),password).
               stream().findFirst();
       if (adminFound.isPresent()) {
           adminFound.get().setLoggedIn(true);
           adminRepoJpa.save(adminFound.get());
           return toAdminDto(adminFound.get());
       }
       return null;

    }

}
