package com.anything.s3.domain.article.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import com.anything.s3.global.exception.handler.S3Exception;
import lombok.Getter;

@Getter
public class AlreadyDoItMemberException extends S3Exception {

    public AlreadyDoItMemberException() {
        super(ErrorCode.ALREADY_DO_IT_MEMBER);
    }
}
