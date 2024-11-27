package com.gdgstudy.jmblog.User.Exceptions;

import com.gdgstudy.jmblog.Common.Exceptions.RejectedRequestException;

public class UserNameDuplicationException extends RejectedRequestException {
    public UserNameDuplicationException() {
        super("Duplicate Username");
    }
}
