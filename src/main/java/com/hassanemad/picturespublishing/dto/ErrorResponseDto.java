package com.hassanemad.picturespublishing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    String message;
    String code;

}
