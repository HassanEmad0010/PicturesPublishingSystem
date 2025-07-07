package com.hassanemad.picturespublishing.controllers;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.errors.HappyResponse;
import com.hassanemad.picturespublishing.services.user.UserServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceInterface userServiceInterface;

    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    log.info("User Controller triggered");
    log.info("User Service injected in User Controller");
    }

    @PostMapping("/register")
    public HappyResponse registerApi(@RequestParam String email, @RequestParam String password) {
         return userServiceInterface.registerUser(new UserDto(email,false), password);
    }

    @PostMapping("/login")
    public HappyResponse loginApi(@RequestParam String email, @RequestParam String password) {
    return userServiceInterface.logIn(email, password);
    }

    @GetMapping("/list_logged")
    public List<UserDto> listLoggedInUsersApi() {
        return userServiceInterface.listLoggedInUsers();
    }



}
