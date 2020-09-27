package com.xgxx.springboot;

import com.xgxx.springboot.entities.Book;
import com.xgxx.springboot.entities.Bookrepository;
import com.xgxx.springboot.entities.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@SpringBootTest
class SpringbootWebApplicationTests {

//    @Autowired
//    DataSource dataSource;

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    Bookrepository bookrepository;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作字符串

    @Autowired
    RedisTemplate redisTemplate;// K-V操作对象的

    /**
     * String (stringRedisTemplate.opsForValue()), list ,Set, Hash, ZSet
     */
    @Test
    public void tets01(){
        //给redis中保存数据
        stringRedisTemplate.opsForValue().append("msg","ceshi");
        String msg = stringRedisTemplate.opsForValue().get("msg");

        System.out.println(msg);
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

    @Test
    void testSaveByOperations(){
        Book book=new Book(2,"西游记2","吴承恩二世");
        IndexQuery indexQuery= new IndexQueryBuilder()
                .withId(book.getId().toString())
                .withObject(book)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of("dongxin"));//返回_id(并非javabean中的ID，而是hits中的)
        System.out.println(documentId);
    }

    @Test
    void testFindByOperations(){
        Book book = elasticsearchOperations.get("2",Book.class,IndexCoordinates.of("dongxin"));//IndexCoordinates的参数为Index
        System.out.println(book.getId()+"--"+book.getBookName()+"--"+book.getAuthor());
    }
    
    @Test
    void setEmployee() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Employee employee = new Employee();
        employee.setdId(4);
        employee.setLastName("董鑫");
        employee.setEmail("526777036@qq.com");
        employee.setdId(1001);
        employee.setBirth(sdf.parse("2020-09-27"));
        employee.setGender(0);
        elasticsearchOperations.save(employee);
//        IndexQuery indexQuery= new IndexQueryBuilder()
//                .withId(employee.getId().toString())
//                .withObject(employee)
//                .build();
//        String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of("megacorp"));//返回_id(并非javabean中的ID，而是hits中的)
//        System.out.println(documentId);
    }

    @Test
    void testGetEmployee(){
        Employee employee =elasticsearchOperations.get("3",Employee.class,IndexCoordinates.of("megacorp"));
        System.out.println(employee);
//        for (Employee employee : bookrepository.findEmployeeByLastNameLike("dong")) {
//            System.out.println(employee);
//        }


    }


}
