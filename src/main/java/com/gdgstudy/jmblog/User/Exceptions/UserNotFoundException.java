package com.gdgstudy.jmblog.User.Exceptions;

import com.gdgstudy.jmblog.Common.Exceptions.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("User Not Found");
    }
}
