package com.hassanemad.picturespublishing.controllers;

import com.hassanemad.picturespublishing.dto.PictureDto;
import com.hassanemad.picturespublishing.errors.HappyResponse;
import com.hassanemad.picturespublishing.services.picture.PictureService;
import com.hassanemad.picturespublishing.services.picture.PictureServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("picture")
public class PictureController {

    private final PictureServiceInterface pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping("/save_pic")
    public HappyResponse savePicApi(@RequestBody PictureDto pictureDto) {
        return pictureService.savePic(pictureDto);
    }

    @GetMapping("/accepted")
    public List<PictureDto> acceptedPicsApi() {
        return pictureService.listAcceptedPics();
    }


    @GetMapping("/list_uploaded")
    public List<PictureDto> listUploadedPicsApi() {
        return pictureService.listUploadedPics();
    }

    @GetMapping("/pic_details")
    public Optional<PictureDto> picDetailsApi(@RequestParam String picId) {
        return pictureService.getPicDetails(picId);
    }

    @PostMapping("/process")
    public PictureDto processPicApi(@RequestParam String picId, @RequestParam boolean status) {
        return pictureService.processPic(picId, status);
    }






}
