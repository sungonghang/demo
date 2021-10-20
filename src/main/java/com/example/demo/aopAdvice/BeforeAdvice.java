package com.example.demo.aopAdvice;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class BeforeAdvice {



     @Before("@annotation(org.aspectj.lang.annotation.Pointcut)")
    private void doBeforeAdvice(){
         System.out.println("====doBefore方法执行了===");

     }
}
