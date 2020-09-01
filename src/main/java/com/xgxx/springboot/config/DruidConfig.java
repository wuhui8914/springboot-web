package com.xgxx.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DruidConfig
 * @Description: TODO
 * @Author dongxin
 * @Date 2020/7/29 0029 下午 2:46
 * @Version: 1.0
 **/

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1.配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initparams = new HashMap<>();
        initparams.put("loginUsername","admin");
        initparams.put("loginPassword","123456");
        initparams.put("allow","");//默认就是允许所有访问
        initparams.put("deny","192.168.43.158");//不允许这个IP访问
        bean.setInitParameters(initparams);
        return bean;
    }
    //2.配置一个监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initparams = new HashMap<>();
        initparams.put("exclusions","*.js,*.css,/druid/*");//排除那些请求
        bean.setInitParameters(initparams);

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
