package com.xgxx.springboot.mapper;

import com.xgxx.springboot.entities.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collection;

/**
 * @ClassName: EmpLoyessMapper
 * @Description: TODO
 * @Author dongxin
 * @Date 2020/7/30 0030 上午 10:29
 * @Version: 1.0
 **/
@Mapper
public interface EmpLoyessMapper {
//注解版
//    @Select("select * from employee")
//    public Collection<Employee> getEmployeeAll();
//
//    @Select("select * from employee where id=#{id}")
//    public Employee getEmployeeId(Integer id);
//
//    @Delete("delete from employee where id=#{id} ")
//    public int deletetEmployeeById(Integer id);
//
//    @Insert("insert into employee(lastName,email,gender,did,birth) values( )")
//    public int insertEmployee(Employee lastName);

    //配置文件版

    public Collection<Employee> getEmployeeAll();

    public Employee getEmployeeId(Integer id);

    public int deletetEmployeeById(Integer id);

    public int insertEmployee(Employee lastName);

    public int updateEmployeeById(Employee employee);
}
