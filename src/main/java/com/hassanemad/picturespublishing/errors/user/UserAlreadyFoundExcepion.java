package com.hassanemad.picturespublishing.errors.user;


public class UserAlreadyFoundExcepion extends RuntimeException {

    public UserAlreadyFoundExcepion(String messageDetail){
        super(messageDetail);
    }

}
