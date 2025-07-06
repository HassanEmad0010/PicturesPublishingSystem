package com.hassanemad.picturespublishing.controllers;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;
import com.hassanemad.picturespublishing.services.admin.AdminServiceInterface;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminServiceInterface adminServiceInterface;
    AdminController(AdminServiceInterface adminServiceInterface) {
        System.out.println("Admin Controller triggered");
        this.adminServiceInterface = adminServiceInterface;
    }

    @PostMapping("/login")
    public AdminDto loginApi(@RequestBody @Valid AdminDto adminDto, @RequestParam String password) {
        return adminServiceInterface.login(adminDto, password);
    }



}

