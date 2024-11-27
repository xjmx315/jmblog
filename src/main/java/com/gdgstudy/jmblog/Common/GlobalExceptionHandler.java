package com.gdgstudy.jmblog.Common;

import com.gdgstudy.jmblog.User.Exceptions.NoLoginUserException;
import com.gdgstudy.jmblog.User.Exceptions.UserNameDuplicationException;
import com.gdgstudy.jmblog.User.Exceptions.UserNotFoundException;
import com.gdgstudy.jmblog.User.Exceptions.UserPermissionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public final class GlobalExceptionHandler {

    //======================================About User
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CommonResponse> handlerUserNotFoundException(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new CommonResponse(404, e.getMessage()));
    }

    @ExceptionHandler(UserNameDuplicationException.class)
    public ResponseEntity<CommonResponse> handlerUserNameDuplicationException(UserNameDuplicationException e){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new CommonResponse(202, e.getMessage()));
    }

    @ExceptionHandler(NoLoginUserException.class)
    public ResponseEntity<CommonResponse> handlerNoLoginUserException(NoLoginUserException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new CommonResponse(401, e.getMessage()));
    }

    @ExceptionHandler(UserPermissionException.class)
    public ResponseEntity<CommonResponse> handlerUserPermissionException(UserPermissionException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new CommonResponse(401, e.getMessage()));
    }
}
