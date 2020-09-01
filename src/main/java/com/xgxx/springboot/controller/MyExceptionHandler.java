package com.xgxx.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @ClassName: MyExceptionHandler
 * @Description: TODO  自定义异常处理器
 * @Author dongxin
 * @Date 2020/7/15 0015 下午 3:58
 * @Version: 1.0
 **/

@ControllerAdvice
public class MyExceptionHandler {

      //1.浏览器客户端返回的都是json数据
//    @ResponseBody
//    @ExceptionHandler(xxx.class) xxx 需要建立对应的XXX.class 类
//    public Map<String,Object> handleException(Exception e){
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

//    @ExceptionHandler(xxx.class) xxx 需要建立对应的XXX.class 类
//    public Map<String,Object> handleException(Exception e){
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        //转发到/error
//        return "forward:/error";
//    }
}
