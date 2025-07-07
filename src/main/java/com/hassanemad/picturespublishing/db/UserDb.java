package com.hassanemad.picturespublishing.db;

import com.hassanemad.picturespublishing.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Deprecated

@Component
public class UserDb {

    public List<User> userEntities;
    public UserDb() {
    this.userEntities = new ArrayList<>();
    userEntities.add(new User("hassan@user.com","123456",false));
    userEntities.add(new User("Yousef@user.com","000000",false));

    }
}
