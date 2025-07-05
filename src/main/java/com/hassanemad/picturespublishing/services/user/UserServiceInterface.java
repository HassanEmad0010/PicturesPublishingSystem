package com.hassanemad.picturespublishing.services.user;

import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.User;

import java.util.List;


public interface UserServiceInterface {
    void registerUser(UserDto userDto, String password);
    boolean logIn(String email, String password);
    List<UserDto> listLoggedInUsers();
    User findUserByEmail(String email);
    void loggOutUsersSession( );
}
