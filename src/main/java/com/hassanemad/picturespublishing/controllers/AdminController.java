package com.hassanemad.picturespublishing.controllers;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;
import com.hassanemad.picturespublishing.services.admin.AdminServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminServiceInterface adminServiceInterface;
    AdminController(AdminServiceInterface adminServiceInterface) {
        System.out.println("Admin Controller triggered");
        this.adminServiceInterface = adminServiceInterface;
    }

    @PostMapping("/login")
    public AdminDto loginApi(@RequestBody AdminDto adminDto, @RequestParam String password) {
        return adminServiceInterface.login(adminDto, password);
    }



}

