package com.example.demo.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aop")
public class AopController {

    @GetMapping(value = "/getTest")
    public JSONObject aopTest(){
        System.out.println("getTest方法执行了");
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }
    @PostMapping(value = "/getTest")
    public JSONObject aopTest2(){
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }

}
