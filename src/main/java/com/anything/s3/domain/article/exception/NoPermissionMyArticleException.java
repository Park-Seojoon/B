package com.anything.s3.domain.article.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import com.anything.s3.global.exception.handler.S3Exception;

public class NoPermissionMyArticleException extends S3Exception {

    public NoPermissionMyArticleException() {
        super(ErrorCode.NOT_PERMISSION_ME);
    }
}
