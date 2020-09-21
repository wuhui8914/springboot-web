package com.xgxx.springboot.entities;

import java.io.Serializable;
import java.util.Date;

//implements Serializable 在接口中使用cacheable 必须对应的实体类要先序列化    要缓存的 Java 对象必须实现 Serializable 接口，因为 Spring 会将对象先序列化再存入 Redis

public class Employee implements Serializable {

	private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private Integer dId;
    private Date birth;

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getdId() {
        return dId;
    }

    public Date getBirth() {
        return birth;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Integer dId, Date birth) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dId = dId;
        this.birth = birth;
    }
}
