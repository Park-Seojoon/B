package com.anything.s3.global.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class TokenExpiredException extends RuntimeException{

    public TokenExpiredException() {
        super(String.valueOf(ErrorCode.TOKEN_EXPIRATION));
    }
}
