package com.gdgstudy.jmblog.User.Exceptions;

public class NoLoginUserException extends RuntimeException {
    public NoLoginUserException(String message) {
        super(message);
    }
}
