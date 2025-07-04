package com.hassanemad.picturespublishing.services.user;

import com.hassanemad.picturespublishing.dto.PictureDto;
import org.springframework.stereotype.Service;


public interface UserServiceInterface {
    String savePic(PictureDto pictureDto);
}
