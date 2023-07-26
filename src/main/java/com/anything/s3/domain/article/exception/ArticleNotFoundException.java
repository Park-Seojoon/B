package com.anything.s3.domain.article.exception;

import com.anything.s3.global.exception.handler.ErrorCode;

public class ArticleNotFoundException extends RuntimeException{

    public ArticleNotFoundException() {
        super(String.valueOf(ErrorCode.ARTICLE_NOT_FOUND));
    }
}
