package com.hassanemad.picturespublishing.services.picture;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.Picture;
import com.hassanemad.picturespublishing.enums.PictureEnum;
import com.hassanemad.picturespublishing.errors.HappyResponse;
import com.hassanemad.picturespublishing.errors.picture.NoPicturesException;
import com.hassanemad.picturespublishing.errors.picture.NotLoggedInException;
import com.hassanemad.picturespublishing.repos.picture.PictureRepoInterfaceJpa;
import com.hassanemad.picturespublishing.services.user.UserServiceJpa;
import com.hassanemad.picturespublishing.utilities.PictureFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



    @Transactional
    @Override
    public PictureDto processPic(String picId, boolean response) {
       Optional<Picture> picFound = findPictureById(picId);
        if (picFound.isPresent() && picFound.get().getPicStatus().equals(PictureEnum.UPLOADED.name())){
            Picture pictureFound= picFound.get();
            if (!response){
                rejectPicture(pictureFound);
                upsert(pictureFound);
                return toPictureDto(pictureFound);
            }
            acceptPicture(pictureFound);
            upsert(pictureFound);
            return toPictureDto(pictureFound);
        }
        throw new NoPicturesException("No uploaded picture for this id: "+picId);
    }


    @Override
    public Optional <PictureDto> getPicDetails(String picId) {
       Optional<Picture> picFound = findPictureById(picId);
       if (picFound.isEmpty()){
            throw new NoPicturesException("Picture not found");
       }
       return picFound.map(PictureFactory::toPictureDto);
    }

    @Override
    public List<PictureDto> listUploadedPics() {
        List<PictureDto> pictureDtoList = listAllPicsByStatus(PictureEnum.UPLOADED) ;
        if (pictureDtoList.isEmpty()){
            throw new NoPicturesException("No uploaded pictures yet!");
        }
        return pictureDtoList;
    }


    @Transactional
    @Override
    public HappyResponse savePic(PictureDto pictureDto) {
        if ( listLoggedInUsers().stream().anyMatch(userDto ->
                userDto.userEmail().equals(pictureDto.userEmail()) &&
                        userDto.isLoggedIn()
                )) {
            Picture picToSave = toPictureEntity(pictureDto);
            upsert(picToSave);
            return new HappyResponse("Picture: "+picToSave.getId()+ " is saved", "000");
        }
        throw new NotLoggedInException("User is not logged in");
    }

    @Override
    public List<PictureDto> listAcceptedPics() {
        List<PictureDto> picturesDto = listAllPicsByStatus(PictureEnum.ACCEPTED) ;
        if (picturesDto.isEmpty()){
            throw  new NoPicturesException("No accepted pictures yet!");
        }
        return picturesDto;
    }

    private Optional<Picture> findPictureById(String picId) {
        return pictureRepoInterfaceJpa.findById(picId);
    }

    private List<UserDto> listLoggedInUsers(){
        return userServiceJpa.listLoggedInUsers();
    }

    private void acceptPicture( final Picture picture){
        picture.setPicStatus(PictureEnum.ACCEPTED.name());
        picture.setUrl("D/Pics/accepted/"+picture.getId().substring(0,4)+".jpg");
    }

    private void rejectPicture( final Picture picture){
        picture.setPicStatus(PictureEnum.REJECTED.name());
    }


    private void upsert(Picture picture) {
        pictureRepoInterfaceJpa.save(picture);
    }


    private List<PictureDto> listAllPics(){
        return pictureRepoInterfaceJpa.findAllByIdNotNull();
     }

    private List<PictureDto> listAllPicsByStatus(PictureEnum status){
    return pictureRepoInterfaceJpa.findAllByPicStatus(status.name());

}



}
