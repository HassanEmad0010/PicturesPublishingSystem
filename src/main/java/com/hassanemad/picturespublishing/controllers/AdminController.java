package com.hassanemad.picturespublishing.controllers;

import com.hassanemad.picturespublishing.dto.AdminDto;
import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.PictureEntity;
import com.hassanemad.picturespublishing.services.admin.AdminService;
import com.hassanemad.picturespublishing.services.admin.AdminServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminServiceInterface adminServiceInterface;
    AdminController(AdminService adminService) {
        System.out.println("Admin Controller triggered");
        this.adminServiceInterface = adminService;
    }

    @PostMapping("/login")
    public AdminDto loginApi(@RequestBody AdminDto adminDto, @RequestParam String password) {
        return adminServiceInterface.login(adminDto, password);
    }

    @GetMapping("/list_uploaded")
    public List<PictureEntity> listUploadedPicsApi() {
        return adminServiceInterface.listUploadedPics();
    }

    @GetMapping("/pic_details")
    public PictureDto picDetailsApi(@RequestParam String picId) {
        return adminServiceInterface.getPicDetails(picId);
    }

    @PostMapping("/process")
    public PictureEntity processPicApi(@RequestParam String picId, @RequestParam boolean status) {
        return adminServiceInterface.processPic(picId, status);
    }


}

