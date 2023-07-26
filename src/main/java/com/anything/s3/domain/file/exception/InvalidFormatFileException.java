package com.anything.s3.domain.file.exception;

import com.anything.s3.global.exception.handler.ErrorCode;

public class InvalidFormatFileException extends RuntimeException{

    public InvalidFormatFileException() {
        super(String.valueOf(ErrorCode.INVALID_FORMAT_FILE));
    }
}
