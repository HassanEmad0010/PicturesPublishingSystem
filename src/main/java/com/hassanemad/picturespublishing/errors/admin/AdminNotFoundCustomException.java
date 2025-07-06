package com.hassanemad.picturespublishing.errors.admin;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AdminNotFoundCustomException extends RuntimeException {
    String messageDetail;

    public AdminNotFoundCustomException(String messageDetail){
        this.messageDetail = messageDetail;
    }


}
