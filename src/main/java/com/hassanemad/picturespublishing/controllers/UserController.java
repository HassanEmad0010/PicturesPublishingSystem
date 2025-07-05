package com.hassanemad.picturespublishing.controllers;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.repos.user.UserRepo;
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

    @PostMapping("/register")
    public void registerApi(@RequestParam String email, @RequestParam String password) {
         userServiceInterface.registerUser(new UserDto(email,false), password);
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
    public String savePicApi(@RequestBody PictureDto pictureDto) {
        return userServiceInterface.savePic(pictureDto,pictureDto.userEmail());
    }

    @GetMapping("accepted")
    public List<PictureDto> acceptedPicsApi() {
        return userServiceInterface.acceptedPics();
    }
}
