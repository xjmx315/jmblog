package com.gdgstudy.jmblog.Common.Exceptions;
//404
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
