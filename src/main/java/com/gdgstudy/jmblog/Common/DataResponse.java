package com.gdgstudy.jmblog.Common;

public class DataResponse<T> extends CommonResponse {
    T data;
    public DataResponse(int code, String msg, T data) {
        super(code, msg);
        this.data = data;
    }
}
