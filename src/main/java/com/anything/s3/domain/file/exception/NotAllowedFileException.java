package com.anything.s3.domain.file.exception;

import com.anything.s3.global.exception.handler.ErrorCode;

public class NotAllowedFileException extends RuntimeException{

    public NotAllowedFileException() {
        super(String.valueOf(ErrorCode.NOT_ALLOWED_FILE));
    }
}
