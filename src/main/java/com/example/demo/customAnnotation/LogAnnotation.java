package com.example.demo.customAnnotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */

@Target({ElementType.METHOD,ElementType.TYPE})
//target注解 用于定义注解的使用位置，如果没有该注解，表示注解可以用在任何地方 TYPE（类，接口，枚举类）
@Retention(RetentionPolicy.RUNTIME)
//rentention注解 指明修饰的注解的生存周期，即会保留到那个阶段,SOURCE(源码级别保留，编译后即丢弃)
//CLASS(编译级别保留，编译后的class文件中，在jvm运行时丢弃，这是默认值)
//RUNTIME(运行级别保留，编译后的class 文件中存在，在jvm运行时保留，可以被反射调用)
public @interface LogAnnotation {
    //@interface 声明一个注解，方法名对应参数名，返回值类型对应参数类型
    String module() default "";
}
