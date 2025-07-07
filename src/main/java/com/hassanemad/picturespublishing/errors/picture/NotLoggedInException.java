package com.hassanemad.picturespublishing.errors.picture;

public class NotLoggedInException extends RuntimeException {
    public NotLoggedInException(String messageDetail){
        super(messageDetail);
    }
}
