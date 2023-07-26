package com.anything.s3.domain.file.exception;

import com.anything.s3.global.exception.handler.ErrorCode;

public class FileUploadFailedException extends RuntimeException{

    public FileUploadFailedException() {
        super(String.valueOf(ErrorCode.FILE_UPLOAD_FAIL));
    }
}
