package com.gdgstudy.jmblog.User.Exceptions;

import com.gdgstudy.jmblog.Common.Exceptions.PermissionException;

public class NoLoginUserException extends PermissionException {
    public NoLoginUserException() {
        super("No Login Data. Must Login First. ");
    }
}
