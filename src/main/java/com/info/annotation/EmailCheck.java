package com.info.annotation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailChek.class)
@Documented
public @interface EmailCheck {

    String message() default "非法邮箱地址";
}