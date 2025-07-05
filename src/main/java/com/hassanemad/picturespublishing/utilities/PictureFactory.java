package com.hassanemad.picturespublishing.utilities;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;

import java.util.UUID;

public class PictureFactory {

    public  static Picture toPictureEntity(PictureDto pictureDto){

        return new Picture(UUID.randomUUID().toString(), pictureDto.userEmail(), "",
                "uploaded", pictureDto.category(), pictureDto.description());
    }
    public  static PictureDto toPictureDto(Picture picture){

        return new PictureDto(picture.getUserEmail(), picture.getCategory(),
                picture.getDescription());
    }
}
