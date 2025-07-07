package com.hassanemad.picturespublishing.errors.user;

public class NoUserException extends RuntimeException {
    public NoUserException(String messageDetail){
        super(messageDetail);
    }
}
