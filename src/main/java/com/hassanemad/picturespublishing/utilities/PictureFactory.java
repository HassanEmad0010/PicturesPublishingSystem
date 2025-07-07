package com.hassanemad.picturespublishing.utilities;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;
import com.hassanemad.picturespublishing.enums.PictureEnum;

import java.util.UUID;

public class PictureFactory {

    public  static Picture toPictureEntity(PictureDto pictureDto){
        return new Picture(UUID.randomUUID().toString(), pictureDto.userEmail(), "",
                PictureEnum.UPLOADED.name(), pictureDto.category(), pictureDto.description());
    }
    public  static PictureDto toPictureDto(Picture picture){

        return new PictureDto(picture.getId(), picture.getUserEmail(), picture.getUrl(), picture.getPicStatus(),
                picture.getCategory(),
                picture.getDescription());
    }
}
