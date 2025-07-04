package com.hassanemad.picturespublishing.factory;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.PictureEntity;

import java.util.UUID;

public class PictureFactory {

    public  static PictureEntity toPictureEntity(PictureDto pictureDto){

        return new PictureEntity(UUID.randomUUID().toString(), pictureDto.userEmail(), "",
                "uploaded", pictureDto.category(), pictureDto.description());
    }
    public  static PictureDto toPictureDto(PictureEntity pictureEntity){

        return new PictureDto(pictureEntity.getUserEmail(), pictureEntity.getCategory(),
                pictureEntity.getDescription());
    }
}
