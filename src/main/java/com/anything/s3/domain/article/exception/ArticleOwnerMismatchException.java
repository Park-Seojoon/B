package com.anything.s3.domain.article.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class ArticleOwnerMismatchException extends RuntimeException{

    public ArticleOwnerMismatchException() {
        super(String.valueOf(ErrorCode.ARTICLE_USER_MISMATCH));
    }
}
