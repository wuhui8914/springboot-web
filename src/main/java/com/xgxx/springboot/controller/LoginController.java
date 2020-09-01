package com.xgxx.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: loginController
 * @Description: TODO
 * @Author dongxin
 * @Date 2020/7/8 0008 下午 5:26
 * @Version: 1.0
 **/

@Controller
public class LoginController {

//    @RequestMapping({"/","/index.html"})
//    public String login(){
//        return "index";
//    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username) &&!StringUtils.isEmpty(password)){

//            String sql=" select 1 from sys_user";
            String sql=" select count(1) from sys_user where username=? and password=? ";
            Integer count = jdbcTemplate.queryForObject(sql,Integer.class,username,password);
            if(count==1){
                session.setAttribute("loginUser",username);
                //登录成功，防止表单重复提交，重定向主页面
                return "redirect:/main.html";
            }else{
                map.put("msg","用户名或密码错误");
                return "index";
            }
        }else{
            map.put("msg","用户名或密码不能为空");
            return "index";
        }

       /* if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            //登录成功，防止表单重复提交，重定向主页面
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或密码错误");
            return "index";
        }*/
    }
}
