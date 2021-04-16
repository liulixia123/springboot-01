package com.lixia.pojo;

import java.util.Date;

//员工表
public class Employee {
    private Integer Id;
    private String lastName;
    private String email;
    private Integer gender;
    private Department department;
    private Date birth;

    public  Employee(){}
    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.Id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();//默认日期创建
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", department=" + department +
                ", birth=" + birth +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
