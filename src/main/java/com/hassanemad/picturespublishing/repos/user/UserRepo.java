//package com.hassanemad.picturespublishing.repos.user;
//
//import com.hassanemad.picturespublishing.db.PictureDb;
//import com.hassanemad.picturespublishing.db.UserDb;
//import com.hassanemad.picturespublishing.entities.Picture;
//import com.hassanemad.picturespublishing.entities.User;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//import java.util.List;
//
//@Component
//@Primary
//public class UserRepo implements UserRepoInterface {
//
//    private final PictureDb db ;
//    private final UserDb userDb;
//    private final PictureDb pictureDb;
//
//    public UserRepo(PictureDb db, UserDb userDb, PictureDb pictureDb) {
//        this.db = db;
//        this.userDb = userDb;
//        this.pictureDb = pictureDb;
//    }
//
//
//    @Override
//    public void registerUser(User user) {
//          userDb.userEntities.add(user);
//    }
//
//    @Override
//    public boolean logIn(String email, String password) {
//      User userFound1 = userDb.userEntities.stream().filter(userEntityFound ->
//                {
//                    if (userEntityFound.getUserEmail().equals(email) &&
//                            userEntityFound.getPassword().equals(password)) {
//                                userEntityFound.setLoggedIn(true);
//                                return true;
//                    }
//                    return false;
//                }
//                ).findFirst().orElse(null);
//
//        return userFound1.isLoggedIn();
//    }
//
//    @Override
//    public String savePic(Picture picture, String email) {
//
//       if (listLoggedInUsers().stream().anyMatch(userEntity ->
//                userEntity.getUserEmail().equals(email))){
//           db.pictureEntities.add(picture);
//           return "Picture uploaded successfully id: "+ picture.getId();
//       }
//       return "You are not logged in";
//
//    }
//
//    @Override
//    public List<User> listLoggedInUsers() {
//        return userDb.userEntities.stream().filter(User::isLoggedIn).toList();
//    }
//
//    @Override
//    public List<Picture> listAcceptedPics() {
//        return pictureDb.pictureEntities.stream().filter(
//                (pictureEntity)->
//                     "approved".equals(pictureEntity.getPicStatus())
//        ).toList();
//    }
//
//}
