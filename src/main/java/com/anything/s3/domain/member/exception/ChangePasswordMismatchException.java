package com.anything.s3.domain.member.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import com.anything.s3.global.exception.handler.S3Exception;
import lombok.Getter;

@Getter
public class ChangePasswordMismatchException extends S3Exception {

    public ChangePasswordMismatchException() {
        super(ErrorCode.MISMATCH_PASSWORD);
    }
}
