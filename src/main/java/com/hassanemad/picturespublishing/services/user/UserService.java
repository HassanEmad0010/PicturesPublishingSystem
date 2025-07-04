package com.hassanemad.picturespublishing.services.user;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.repos.user.UserRepoInterface;
import org.springframework.stereotype.Service;

import static com.hassanemad.picturespublishing.factory.PictureFactory.toPictureEntity;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepoInterface userRepo;
    public UserService(UserRepoInterface userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String savePic(PictureDto pictureDto) {
        return userRepo.savePic(toPictureEntity(pictureDto));
    }
}
