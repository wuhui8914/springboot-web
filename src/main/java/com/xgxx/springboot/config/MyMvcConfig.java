package com.xgxx.springboot.config;

import com.xgxx.springboot.commponent.LoginHandlerInterceptor;
import com.xgxx.springboot.commponent.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName: MyMvcConfig
 * @Description: TODO
 * @Author dongxin
 * @Date 2020/7/9 0009 上午 9:21
 * @Version: 1.0
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //    @Bean
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //静态资源 springboot已经做好了静态资源映射，所以不用写
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "index", "/user/login");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
