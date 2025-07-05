package com.hassanemad.picturespublishing.utilities;

import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.User;

public class UserFactory {
    public static UserDto toUserDto(User user){
        return new UserDto(user.getUserEmail(), user.isLoggedIn());
    }

    public static User toUserEntity(UserDto userDto, String password){
        return new User(userDto.userEmail(), password, userDto.isLoggedIn());
    }
}
