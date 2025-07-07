package com.hassanemad.picturespublishing.errors.picture;

public class NoPicturesException extends RuntimeException {
    public NoPicturesException(String messageDetail){
        super(messageDetail);
    }
}
