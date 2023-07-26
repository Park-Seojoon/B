package com.anything.s3.domain.auth.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import com.anything.s3.global.exception.handler.S3Exception;
import lombok.Getter;

@Getter
public class UserNotFoundException extends S3Exception {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
