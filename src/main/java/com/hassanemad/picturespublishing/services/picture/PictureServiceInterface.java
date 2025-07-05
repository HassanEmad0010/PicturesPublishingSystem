package com.hassanemad.picturespublishing.services.picture;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;

import java.util.List;
import java.util.Optional;

import static com.hassanemad.picturespublishing.utilities.PictureFactory.toPictureDto;

public interface PictureServiceInterface {

    PictureDto processPic(String picId, boolean response);
    Optional<PictureDto> getPicDetails(String picId);
    List<PictureDto> listUploadedPics();
    String savePic(PictureDto pictureDto);
    List<PictureDto> acceptedPics();



}
