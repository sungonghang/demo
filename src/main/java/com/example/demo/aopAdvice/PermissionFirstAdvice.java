package com.example.demo.aopAdvice;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PermissionFirstAdvice {

     @Pointcut("@annotation(com.example.demo.customAnnotation.PermissionAnnotation)")
    public void permissionCheck(){}

     @Around(value = "permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
         System.out.println("============第一个切面========="+System.currentTimeMillis());
         //获取接口参数
         Object[] objects = joinPoint.getArgs();
         Long id = ((JSONObject) objects[0]).getLong("id");
         String name = ((JSONObject) objects[0]).getString("name");
         System.out.println("id1>>>>>>>>>>"+id);
         System.out.println("name1>>>>>"+name);
         if (id < 0) {
             return JSON.parseObject("{\"message\":\"illegal id\",\"code\":403}");
         }
        return joinPoint.proceed();

     }
}
