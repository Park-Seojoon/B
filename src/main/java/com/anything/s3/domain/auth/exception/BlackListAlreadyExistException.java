package com.anything.s3.domain.auth.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class BlackListAlreadyExistException extends RuntimeException{

    public BlackListAlreadyExistException() {
        super(String.valueOf(ErrorCode.BLACK_LIST_ALREADY_EXIST));
    }
}
