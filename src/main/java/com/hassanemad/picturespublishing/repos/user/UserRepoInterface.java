package com.hassanemad.picturespublishing.repos.user;

import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.PictureEntity;
import com.hassanemad.picturespublishing.entities.UserEntity;

import java.util.List;

public interface UserRepoInterface {
     boolean logIn(String email, String password);
     String savePic(PictureEntity pictureEntity,String email);
     List<UserEntity> listLoggedInUsers ();

}
