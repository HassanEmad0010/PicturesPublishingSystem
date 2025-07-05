package com.hassanemad.picturespublishing.services.user;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.repos.user.UserRepoInterface;
import com.hassanemad.picturespublishing.utilities.UserFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hassanemad.picturespublishing.utilities.PictureFactory.toPictureEntity;
import static com.hassanemad.picturespublishing.utilities.UserFactory.toUserDto;
import static com.hassanemad.picturespublishing.utilities.UserFactory.toUserEntity;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepoInterface userRepo;
    public UserService(UserRepoInterface userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean logIn(String email, String password) {
        return userRepo.logIn(email, password);
    }

    @Override
    public String savePic(PictureDto pictureDto, String email) {
        return userRepo.savePic(toPictureEntity(pictureDto),email);
    }

    @Override
    public List<UserDto> listLoggedInUsers() {
        return userRepo.listLoggedInUsers().stream().map(UserFactory::toUserDto).toList();
    }
}
