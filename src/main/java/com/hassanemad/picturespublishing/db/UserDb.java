package com.hassanemad.picturespublishing.db;

import com.hassanemad.picturespublishing.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDb {

    public List<UserEntity> userEntities;
    public UserDb() {
    this.userEntities = new ArrayList<>();
    userEntities.add(new UserEntity("hassan@user.com","123456",false));
    userEntities.add(new UserEntity("Yousef@user.com","000000",false));

    }
}
