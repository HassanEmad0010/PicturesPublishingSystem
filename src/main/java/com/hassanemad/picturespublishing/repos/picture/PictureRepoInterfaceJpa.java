package com.hassanemad.picturespublishing.repos.picture;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepoInterfaceJpa extends JpaRepository<Picture, String> {

    List<PictureDto> findAllByPicStatus(String picStatus);
    List<PictureDto> findAllByIdNotNull();

}
