package com.gdgstudy.jmblog._devCommon;

public class DataResponse<T> extends CommonResponse {
    T data;
    public DataResponse(int code, String msg, T data) {
        super(code, msg);
        this.data = data;
    }
}
