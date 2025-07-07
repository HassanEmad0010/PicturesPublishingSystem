package com.hassanemad.picturespublishing.dto;

public record PictureDto(
        String id,
        String userEmail,
        String url,
        String picStatus,
        String category,
        String description
) {}
