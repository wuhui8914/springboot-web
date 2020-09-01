package com.xgxx.springboot.entities;

import java.util.Date;

public class Employee {

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
}
