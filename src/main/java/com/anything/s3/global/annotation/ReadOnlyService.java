package com.anything.s3.global.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Service
@Transactional(readOnly = true)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnlyService {
}
