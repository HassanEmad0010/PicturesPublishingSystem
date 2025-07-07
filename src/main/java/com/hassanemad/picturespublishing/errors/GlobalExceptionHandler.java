package com.hassanemad.picturespublishing.errors;

import com.hassanemad.picturespublishing.dto.ErrorResponseDto;
import com.hassanemad.picturespublishing.errors.admin.AdminNotFoundCustomException;
import com.hassanemad.picturespublishing.errors.picture.NoPicturesException;
import com.hassanemad.picturespublishing.errors.picture.NotLoggedInException;
import com.hassanemad.picturespublishing.errors.user.InvalidCredentialsException;
import com.hassanemad.picturespublishing.errors.user.NoUserException;
import com.hassanemad.picturespublishing.errors.user.UserAlreadyFoundExcepion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdminNotFoundCustomException.class)

    public ResponseEntity<ErrorResponseDto> adminArgumentNotValidException(AdminNotFoundCustomException ex){
    ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessageDetail(), "10");
    return new ResponseEntity<>(errorResponseDto,
            HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserAlreadyFoundExcepion.class)
    public ResponseEntity<ErrorResponseDto> userAlreadyFoundException(
            UserAlreadyFoundExcepion ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(), "20");
        return new ResponseEntity<>(errorResponseDto,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponseDto> userInvalidCredentialsException(
            InvalidCredentialsException ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(), "21");
        return new ResponseEntity<>(errorResponseDto,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoUserException.class)
    public ResponseEntity<ErrorResponseDto> userNoUserException(Exception ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(),
                "22");
        return new ResponseEntity<>(errorResponseDto,
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotLoggedInException.class)
    public ResponseEntity<ErrorResponseDto> pictureUserNotLoggedInException(Exception ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(),
                "100");
        return new ResponseEntity<>(errorResponseDto,
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoPicturesException.class)
    public ResponseEntity<ErrorResponseDto> pictureNotFoundException(Exception ex){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(),
                "101");
        return new ResponseEntity<>(errorResponseDto,
                HttpStatus.BAD_REQUEST);
    }
    
    
    
}
