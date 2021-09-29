package com.example.demo.customAnnotation;


/**
 * 自定义注解
 */
public @interface LogAnnotation {
    String module() default "";
}
