package com.anything.s3.domain.auth.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import com.anything.s3.global.exception.handler.S3Exception;

public class DuplicatedNameException extends S3Exception {

    public DuplicatedNameException() {
        super(ErrorCode.NAME_ALREADY_EXIST);
    }
}
