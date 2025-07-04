package com.hassanemad.picturespublishing.controllers;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.services.admin.AdminService;
import com.hassanemad.picturespublishing.services.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String savePicApi(@RequestBody PictureDto pictureDto) {
        return userService.savePic(pictureDto);
    }
}
