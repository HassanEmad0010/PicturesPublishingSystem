package com.hassanemad.picturespublishing.errors;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class HappyResponse {
    String message;
    String code;


}
