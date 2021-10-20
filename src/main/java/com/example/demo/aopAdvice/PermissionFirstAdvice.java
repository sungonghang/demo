package com.example.demo.aopAdvice;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PermissionFirstAdvice {

    @Pointcut("@annotation(com.example.demo.customAnnotation.PermissionAnnotation)")
    public void permissionCheck(){}

     @Around(value = "permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {//方法的形参必须是ProceedingJoinPoint

        //around 增强处理非常的强大，表现在
         //1.around 可以自由选择增强动作与目标方法的执行顺序，也就是说可以在增强动作前后，甚至过程中执行目标的方法，这个方法的
         //的执行实现在于，调用ProceedingJoinPoint 参数的proceed()方法才会执行目标方法
         //2.@Around可以改变执行目标方法的参数，也可以改变执行目标方法z之后的返回值


//         /*
//           调用ProceedingJoinPoint的proceed()方法是，可以传入一个Object[]对象，该数组中的值将被传入目标方法作为实参————-
         //这就是Around增强处理方法可以改变目标方法参数值的关键，如果传入的object[]数组长度与目标方法
         // 所需要的参数个数不相等，或与目标方法所需的参数类型不匹配，程序就会出现异常        */
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
