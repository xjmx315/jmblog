package com.gdgstudy.jmblog.Common;

import lombok.Getter;

@Getter
public class CommonResponse {
    int code;
    String msg;
    public CommonResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
