package com.gdgstudy.jmblog.Common;

import com.gdgstudy.jmblog.Common.Exceptions.NotFoundException;
import com.gdgstudy.jmblog.Common.Exceptions.PermissionException;
import com.gdgstudy.jmblog.Common.Exceptions.RejectedRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public final class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CommonResponse> handlerNotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new CommonResponse(404, e.getMessage()));
    }

    @ExceptionHandler(PermissionException.class)
    public ResponseEntity<CommonResponse> handlerPermissionException(PermissionException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new CommonResponse(401, e.getMessage()));
    }

    @ExceptionHandler(RejectedRequestException.class)
    public ResponseEntity<CommonResponse> handlerRejectedRequestException(RejectedRequestException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new CommonResponse(202, e.getMessage()));
    }

    /*
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
    */
}
