package com.cvs.store.common.model;

import org.springframework.http.HttpStatus;

public record CommonResponse<T>(T data, Integer code) {
    public CommonResponse{
        if(code == null){
            code = HttpStatus.OK.value();
        }
    }
}
