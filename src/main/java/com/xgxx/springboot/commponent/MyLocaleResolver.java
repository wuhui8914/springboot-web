package com.xgxx.springboot.commponent;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName: MyLocaleResolver
 * @Description: 可以在链接上携带区域信息
 * @Author dongxin
 * @Date 2020/7/8 0008 下午 5:20
 * @Version: 1.0
 **/
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest requset) {
        String l = requset.getParameter("l");
        Locale locale = Locale.getDefault();//系统默认的
        if(!StringUtils.isEmpty(l)){
            String [] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
