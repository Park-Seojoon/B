package com.anything.s3.global.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class TokenNotValidException extends RuntimeException{

    public TokenNotValidException() {
        super(String.valueOf(ErrorCode.TOKEN_NOT_VALID));
    }
}
