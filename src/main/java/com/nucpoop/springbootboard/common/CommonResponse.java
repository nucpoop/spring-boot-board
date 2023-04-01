package com.nucpoop.springbootboard.common;

import lombok.Getter;

@Getter
public class CommonResponse<T> {
    private String status;
    private T data;
    private String message;

    private CommonResponse(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this. message = message;
    }
}
