package com.gdgstudy.jmblog.User.Exceptions;

public class NoLoginUserException extends RuntimeException {
    public NoLoginUserException() {
        super("No Login Data. Must Login First. ");
    }
}
