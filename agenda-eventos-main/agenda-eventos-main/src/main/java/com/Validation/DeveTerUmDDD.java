package com.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface DeveTerUmDDD {
    String message() default "O campo deve conter o DDD de Glasgow.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
