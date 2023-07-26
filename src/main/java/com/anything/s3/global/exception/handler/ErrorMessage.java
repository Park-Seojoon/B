package com.anything.s3.global.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private final int status;

    public ErrorMessage(ErrorCode errorCode){
        this(errorCode.getStatus());
    }
}