package com.hassanemad.picturespublishing.services.admin;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.entities.Admin;
import com.hassanemad.picturespublishing.errors.admin.AdminNotFoundCustomException;
import com.hassanemad.picturespublishing.repos.admin.AdminRepoJpa;

import jakarta.annotation.PreDestroy;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static com.hassanemad.picturespublishing.utilities.AdminFactory.*;

@Component
@Primary
public class AdminService implements AdminServiceInterface {
AdminRepoJpa adminRepoJpa;

    public AdminService(AdminRepoJpa adminRepoJpa) {
        this.adminRepoJpa = adminRepoJpa;

    }

    @Override
    @PreDestroy
    @Transactional
    public void loggOutAdminsSession() {
        adminRepoJpa.findAll().forEach(user -> {
                    user.setLoggedIn(false);
                    adminRepoJpa.save(user);
                }
        );
    }

    @Override
    public AdminDto login(AdminDto adminDto, String password) {
        Admin adminFound= getAdmin(adminDto.userName(),password);
        adminFound.setLoggedIn(true);
        adminRepoJpa.save(adminFound);
        return toAdminDto(adminFound);

    }

    @Override
    public Admin getAdmin (String userName, String password){
       return  adminRepoJpa.findByUsernameAndPassword(userName,password).
                stream()
                .findFirst()
                .orElseThrow(() -> new AdminNotFoundCustomException("Error in admin login. Please check your username and password"));
    }

}
