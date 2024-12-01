package com.gdgstudy.jmblog.Post.Exceptions;

import com.gdgstudy.jmblog._devCommon.Exceptions.NotFoundException;

public class PostNotFoundException extends NotFoundException {
    public PostNotFoundException() {
        super("Post Not Found");
    }
}
