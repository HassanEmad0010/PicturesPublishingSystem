package com.hassanemad.picturespublishing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PictureEntity {
private String id;
private String userEmail;
private String url;
private String picStatus;
private String category;
private String description;
}
