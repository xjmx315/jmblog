package com.gdgstudy.jmblog.User.Exceptions;

import com.gdgstudy.jmblog._devCommon.Exceptions.PermissionException;

public class NoLoginUserException extends PermissionException {
    public NoLoginUserException() {
        super("No Login Data. Must Login First. ");
    }
}
