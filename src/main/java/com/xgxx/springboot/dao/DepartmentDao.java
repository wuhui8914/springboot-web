package com.xgxx.springboot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.xgxx.springboot.entities.Department;
import com.xgxx.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDao {

	@Autowired
	DepartmentMapper departmentMapper;

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

//	private static Map<Integer, Department> departments = null;
//
//	static{
//		departments = new HashMap<Integer, Department>();
//
//		departments.put(101, new Department(101, "D-AA"));
//		departments.put(102, new Department(102, "D-BB"));
//		departments.put(103, new Department(103, "D-CC"));
//		departments.put(104, new Department(104, "D-DD"));
//		departments.put(105, new Department(105, "D-EE"));
//	}

	/**
	 * @Author dongxin
	 * @Description //TODO 获取所有的的组织
	 * @Date 2020/7/30 0030  上午 10:05 
	 * @Param []
	 * @return java.util.Collection<com.xgxx.springboot.entities.Department>
	 **/

	@Cacheable(cacheNames  = "depId")
	public Collection<Department> getDepartments(){
		return departmentMapper.getDeptAll();
	}


	public Department getDepartment(Integer id){
		return departmentMapper.getDeptById(id);
	}
	
}
