package com.gdgstudy.jmblog.User.Exceptions;

import com.gdgstudy.jmblog._devCommon.Exceptions.RejectedRequestException;

public class UserNameDuplicationException extends RejectedRequestException {
    public UserNameDuplicationException() {
        super("Duplicate Username");
    }
}
