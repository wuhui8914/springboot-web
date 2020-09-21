package com.xgxx.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import javax.xml.bind.SchemaOutputResolver;
import java.sql.Connection;

@SpringBootTest
class SpringbootWebApplicationTests {

//    @Autowired
//    DataSource dataSource;

//    @Autowired
//    StringRedisTemplate stringRedisTemplate; //操作字符串
//
//    @Autowired
//    RedisTemplate redisTemplate;// K-V操作对象的

    /**
     * String (stringRedisTemplate.opsForValue()), list ,Set, Hash, ZSet
     */
    @Test
    public void tets01(){
        //给redis中保存数据
       // stringRedisTemplate.opsForValue().append("msg","ceshi");
//        String msg = stringRedisTemplate.opsForValue().get("msg");

//        System.out.println(msg);
    }

    @Test
    void contextLoads() throws  Exception{
//        System.out.println(dataSource.getClass()+"11111");
//
//        Connection connection = dataSource.getConnection();
//
//        System.out.println(connection+"222");
//        connection.close();



    }

}
