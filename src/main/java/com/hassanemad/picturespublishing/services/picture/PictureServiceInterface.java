package com.hassanemad.picturespublishing.services.picture;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;
import com.hassanemad.picturespublishing.enums.PictureEnum;
import com.hassanemad.picturespublishing.errors.HappyResponse;

import java.util.List;
import java.util.Optional;

public interface PictureServiceInterface {

    PictureDto processPic(String picId, boolean response);
    Optional<PictureDto> getPicDetails(String picId);
    List<PictureDto> listUploadedPics();
    HappyResponse savePic(PictureDto pictureDto);
    List<PictureDto> listAcceptedPics();



}
