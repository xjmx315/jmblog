package com.gdgstudy.jmblog.User.Exceptions;

public class UserNameDuplicationException extends RuntimeException {
    public UserNameDuplicationException() {
        super("Duplicate Username");
    }
}
