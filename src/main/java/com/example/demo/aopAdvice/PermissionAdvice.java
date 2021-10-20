package com.example.demo.aopAdvice;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value = 1)
public class PermissionAdvice {

    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    //第一个*号的位置表示 返回值的类型 * 代表所有类型，
    //包名后的两个句点表示当前包以及当前包下的所有子包
    //第二个*表示的是类名，*表示所有的类
    //*(..)中的*表示方法名，*表示所有方法，后面括号表示方法的参数，连个句点表示所有参数
    private void permissionCheck(){};

    @Around("permissionCheck()")
    public Object permissionCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=========开始进行增强========");
        Object[] args = joinPoint.getArgs();
        JSONObject jsonObject = (JSONObject) args[0];
        Long id = jsonObject.getLong("id");
        String name  = jsonObject.getString("name");
        System.out.println("id===="+id + ",name===="+name);
        JSONObject result =new JSONObject();
        result.put("id","333");
        result.put("name","wangwu");
        args[0] = result;
        return joinPoint.proceed(args);
    }




}
