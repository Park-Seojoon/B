package com.anything.s3.global.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    AUTH_CODE_MISMATCH(400),
    EMAIL_MISMATCH( 400),
    WRONG_PASSWORD( 400),
    MISMATCH_PASSWORD( 400),
    EMAIL_NOT_VERIFIED(401),
    TOKEN_EXPIRATION( 401),
    TOKEN_NOT_VALID(401),
    ARTICLE_USER_MISMATCH( 403),
    USER_NOT_FOUND(404),
    ARTICLE_NOT_FOUND(404),
    REFRESH_TOKEN_NOT_FOUND( 404),
    EMAIL_NOT_FOUND( 404),
    COMMENT_NOT_FOUND(404),
    BLACK_LIST_ALREADY_EXIST(409),
    EMAIL_ALREADY_EXIST(409),
    NAME_ALREADY_EXIST(409),
    ARTICLE_TITLE_EXIST(409),
    CLASS_NUMBER_ALREADY_EXIST(409),
    MANY_REQUEST_EMAIL_AUTH(429),
    EMAIL_SEND_FAIL(500),
    FAILED_UPLOAD_IMAGE(500),
    FILE_UPLOAD_FAIL(500),
    NOT_ALLOWED_FILE(400),
    INVALID_FORMAT_FILE(400),
    NOT_PERMISSION_ME(403),
    ALREADY_DO_IT_MEMBER(409);

    private final int status;
}
