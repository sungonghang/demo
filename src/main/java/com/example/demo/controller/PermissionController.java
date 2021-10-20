package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.customAnnotation.PermissionAnnotation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {


    @RequestMapping(value = "/check")
    @PermissionAnnotation
    public JSONObject getGroupList(@RequestBody JSONObject request){
        return JSONObject.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }

}
