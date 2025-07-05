package com.hassanemad.picturespublishing.controllers;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.services.user.UserService;
import com.hassanemad.picturespublishing.services.user.UserServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceInterface userServiceInterface;
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @PostMapping("/login")
    public boolean loginApi(@RequestParam String email, @RequestParam String password) {
    return userServiceInterface.logIn(email, password);
    }

    @GetMapping("/list_logged")
    public List<UserDto> listLoggedInUsersApi() {
        return userServiceInterface.listLoggedInUsers();
    }

    @PostMapping("/save")
    public String savePicApi(@RequestBody PictureDto pictureDto, @RequestParam String email) {
        return userServiceInterface.savePic(pictureDto,email);
    }
}
