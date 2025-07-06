package com.hassanemad.picturespublishing.errors;

import com.hassanemad.picturespublishing.dto.ErrorResponseDto;
import com.hassanemad.picturespublishing.errors.admin.AdminNotFoundCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdminNotFoundCustomException.class)

    public ResponseEntity<ErrorResponseDto> argumentNotValidException(AdminNotFoundCustomException ex){
    ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessageDetail(), "400");
    return new ResponseEntity<>(errorResponseDto,
            HttpStatus.BAD_REQUEST);
    }
}
