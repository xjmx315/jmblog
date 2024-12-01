package com.gdgstudy.jmblog.User.Exceptions;

import com.gdgstudy.jmblog._devCommon.Exceptions.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("User Not Found");
    }
}
