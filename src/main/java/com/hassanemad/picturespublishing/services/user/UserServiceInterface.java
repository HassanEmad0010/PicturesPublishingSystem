package com.hassanemad.picturespublishing.services.user;

import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.User;
import com.hassanemad.picturespublishing.errors.HappyResponse;

import java.util.List;


public interface UserServiceInterface {
    HappyResponse registerUser(UserDto userDto, String password);
    HappyResponse logIn(String email, String password);
    List<UserDto> listLoggedInUsers();
    User findUserByEmail(String email);
    void loggOutUsersSession( );
}
