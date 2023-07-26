package com.anything.s3.domain.auth.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class MisMatchPasswordException extends RuntimeException{

    public MisMatchPasswordException() {
        super(String.valueOf(ErrorCode.WRONG_PASSWORD));
    }
}
