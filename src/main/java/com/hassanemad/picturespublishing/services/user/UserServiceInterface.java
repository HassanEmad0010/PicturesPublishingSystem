package com.hassanemad.picturespublishing.services.user;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.dto.UserDto;

import java.util.List;


public interface UserServiceInterface {
    void registerUser(UserDto userDto, String password);
    boolean logIn(String email, String password);
    String savePic(PictureDto pictureDto,String email);
    List<UserDto> listLoggedInUsers();
    List<PictureDto> acceptedPics();

}
