package com.hassanemad.picturespublishing.services.picture;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;
import com.hassanemad.picturespublishing.repos.picture.PictureRepoInterfaceJpa;
import com.hassanemad.picturespublishing.services.user.UserServiceJpa;
import com.hassanemad.picturespublishing.utilities.PictureFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.hassanemad.picturespublishing.utilities.PictureFactory.toPictureDto;
import static com.hassanemad.picturespublishing.utilities.PictureFactory.toPictureEntity;

@Service
public class PictureService implements PictureServiceInterface {

    private final PictureRepoInterfaceJpa pictureRepoInterfaceJpa;
    private final UserServiceJpa userServiceJpa;

    public PictureService(PictureRepoInterfaceJpa pictureRepoInterfaceJpa, UserServiceJpa userServiceJpa) {
        this.userServiceJpa = userServiceJpa;
        this.pictureRepoInterfaceJpa = pictureRepoInterfaceJpa;
    }

    public Optional<Picture> findPictureById(String picId) {
        return pictureRepoInterfaceJpa.findById(picId);
    }

    @Override
    public PictureDto processPic(String picId, boolean response) {
       Optional<Picture> picFound = pictureRepoInterfaceJpa.findById(picId);
        if (picFound.isPresent() && picFound.get().getPicStatus().equals("uploaded")){
           picFound.get().setPicStatus(response ? "accepted" : "rejected");
           pictureRepoInterfaceJpa.save(picFound.get());
            return toPictureDto(picFound.get());
        }
        return null;
    }

    @Override
    public Optional <PictureDto> getPicDetails(String picId) {
       Optional<Picture> picFound = pictureRepoInterfaceJpa.findById(picId);
       return picFound.map(PictureFactory::toPictureDto);
    }

    @Override
    public List<PictureDto> listUploadedPics() {
        return pictureRepoInterfaceJpa.findAllByPicStatus("uploaded");
    }


    @Override
    public String savePic(PictureDto pictureDto) {
        if ( userServiceJpa.listLoggedInUsers().stream().anyMatch(userDto ->
                userDto.userEmail().equals(pictureDto.userEmail()) &&
                        userDto.isLoggedIn()
                )) {
            Picture picSaved = pictureRepoInterfaceJpa.save(toPictureEntity(pictureDto));
            return picSaved.getId()  + " Picture is saved";
        }
        return "User is not logged in";

    }

    @Override
    public List<PictureDto> acceptedPics() {
        return pictureRepoInterfaceJpa.findAllByPicStatus("accepted");
    }





}
