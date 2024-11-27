package com.gdgstudy.jmblog.User.Exceptions;

public class UserPermissionException extends RuntimeException {
    public UserPermissionException() {
        super("You Have Not Permission For");
        //비밀번호가 다른 경우
    }
}
