package com.hassanemad.picturespublishing.repos.user;

import com.hassanemad.picturespublishing.db.PictureDb;
import com.hassanemad.picturespublishing.db.UserDb;
import com.hassanemad.picturespublishing.entities.PictureEntity;
import com.hassanemad.picturespublishing.entities.UserEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Primary
public class UserRepo implements UserRepoInterface {

    private final PictureDb db ;
    private final UserDb userDb;
    private final PictureDb pictureDb;

    public UserRepo(PictureDb db, UserDb userDb, PictureDb pictureDb) {
        this.db = db;
        this.userDb = userDb;
        this.pictureDb = pictureDb;
    }


    @Override
    public void registerUser(UserEntity userEntity) {
          userDb.userEntities.add(userEntity);
    }

    @Override
    public boolean logIn(String email, String password) {
      UserEntity UserEntityFound1 = userDb.userEntities.stream().filter(userEntityFound ->
                {
                    if (userEntityFound.getUserEmail().equals(email) &&
                            userEntityFound.getPassword().equals(password)) {
                                userEntityFound.setLoggedIn(true);
                                return true;
                    }
                    return false;
                }
                ).findFirst().orElse(null);

        return UserEntityFound1.isLoggedIn();
    }

    @Override
    public String savePic(PictureEntity pictureEntity, String email) {

       if (listLoggedInUsers().stream().anyMatch(userEntity ->
                userEntity.getUserEmail().equals(email))){
           db.pictureEntities.add(pictureEntity);
           return "Picture uploaded successfully id: "+ pictureEntity.getId();
       }
       return "You are not logged in";

    }

    @Override
    public List<UserEntity> listLoggedInUsers() {
        return userDb.userEntities.stream().filter(UserEntity::isLoggedIn).toList();
    }

    @Override
    public List<PictureEntity> listAcceptedPics() {
        return pictureDb.pictureEntities.stream().filter(
                (pictureEntity)->
                     "approved".equals(pictureEntity.getPicStatus())
        ).toList();
    }

}
