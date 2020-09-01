package com.xgxx.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import javax.xml.bind.SchemaOutputResolver;
import java.sql.Connection;

@SpringBootTest
class SpringbootWebApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws  Exception{
        System.out.println(dataSource.getClass()+"11111");

        Connection connection = dataSource.getConnection();

        System.out.println(connection+"222");
        connection.close();


    }

}
