package com.hassanemad.picturespublishing.errors.user;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String messageDetail){
        super(messageDetail);
    }
}
