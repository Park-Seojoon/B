package com.anything.s3.global.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(S3Exception.class)
    public ResponseEntity<ErrorMessage> handleComprehensiveException(HttpServletRequest request, S3Exception e) {
        printError(request, e.getErrorCode().getStatus());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatusCode.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        printError(request, 400);
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    private void printError(HttpServletRequest request, int status) {
        log.error(request.getRequestURI());
        log.error(String.valueOf(status));
    }
}
