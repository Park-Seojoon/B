package com.anything.s3.domain.auth.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicatedEmailException extends RuntimeException{

    public DuplicatedEmailException() {
        super(String.valueOf(ErrorCode.EMAIL_ALREADY_EXIST));
    }
}
