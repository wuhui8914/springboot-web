package com.xgxx.springboot.mapper;

import com.xgxx.springboot.entities.Department;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

/**
 * @ClassName: departmentMapper
 * @Description: TODO
 * @Author dongxin
 * @Date 2020/7/30 0030 上午 10:07
 * @Version: 1.0
 **/

@Mapper
public interface DepartmentMapper {
//注解版
//    @Select("select * from department")
//    public Collection<Department> getDeptAll();
//
//    @Select("select * from department where id=#{id}")
//    public Department getDeptById(Integer id);
//
//    @Delete("delete from department where id=#{id}")
//    public int deleteDeptByid(Integer id);
//
//    @Insert("insert into department(departmentName) values (#{departmentName})")
//    public int insertDept(Department department);
//
//    @Update("update  department set departmentName=#{departmentName} where id=#{id} ")
//    public int updateDept(Department  department);

    //配置文件版

    public Collection<Department> getDeptAll();

    public Department getDeptById(Integer id);

    public int deleteDeptById(Integer id);

    public int insertDept(Department department);

    public int updateDeptById(Department  department);
}
