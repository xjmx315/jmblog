package com.gdgstudy.jmblog.User.Exceptions;

import com.gdgstudy.jmblog._devCommon.Exceptions.PermissionException;

public class UserPermissionException extends PermissionException {
    public UserPermissionException() {
        super("This User Have Not Permission For");
        //비밀번호가 다른 경우
    }
}
