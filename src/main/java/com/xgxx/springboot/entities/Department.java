package com.xgxx.springboot.entities;


import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;

//implements Serializable 在接口中使用cacheable 必须对应的实体类要先序列化    要缓存的 Java 对象必须实现 Serializable 接口，因为 Spring 会将对象先序列化再存入 Redis
public class Department implements Serializable {

	private Integer id;
	private String departmentName;

	public Integer getId() {
		return id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


}
