package com.anything.s3.domain.article.exception;

import com.anything.s3.global.exception.handler.ErrorCode;

public class ExistTitleException extends RuntimeException{

    public ExistTitleException() {
        super(String.valueOf(
                ErrorCode.ARTICLE_TITLE_EXIST
        ));
    }
}
