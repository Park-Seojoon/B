package com.anything.s3.domain.auth.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class RefreshTokenNotFoundException extends RuntimeException{

    public RefreshTokenNotFoundException() {
        super(String.valueOf(ErrorCode.REFRESH_TOKEN_NOT_FOUND));
    }
}
