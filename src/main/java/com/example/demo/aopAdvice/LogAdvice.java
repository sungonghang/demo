package com.example.demo.aopAdvice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
     //定义一个切点：所有被GetMapping注解修饰的方法会织入advice
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void logAdvicePointcut(){}
    //before表示logAdvice将在目标方法执行前处理0
    @Before("logAdvicePointcut()")
    public void  logAdvice(JoinPoint joinPoint){
        System.out.println("get请求的前置Advice触发了");
    }

    @Around(value = "@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void  around(JoinPoint joinPoint){



    }


}
