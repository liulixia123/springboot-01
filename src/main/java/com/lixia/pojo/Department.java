package com.lixia.pojo;
//部门信息
public class Department {
    private int Id;
    private String departmentName;

    public Department() {
    }

    public Department(int id, String departmentName){
        this.Id = id;
        this.departmentName = departmentName;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "Id=" + Id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
