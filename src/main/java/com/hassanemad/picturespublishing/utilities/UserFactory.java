package com.hassanemad.picturespublishing.utilities;

import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.UserEntity;

public class UserFactory {
    public static UserDto toUserDto(UserEntity userEntity){
        return new UserDto(userEntity.getUserEmail(), userEntity.isLoggedIn());
    }

    public static UserEntity toUserEntity(UserDto userDto, String password){
        return new UserEntity(userDto.userEmail(), password, userDto.isLoggedIn());
    }
}
