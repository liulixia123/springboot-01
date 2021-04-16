package com.lixia.dao;

import com.lixia.pojo.Department;
import com.lixia.pojo.Employee;

import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Resource
    public DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"张三","151@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"李四","15132@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"王五","15133@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"笑笑","15134@qq.com",1,new Department(104,"后勤部")));
        employees.put(1005,new Employee(1005,"梅梅","15135@qq.com",1,new Department(105,"运营部")));
    }
    //主键自增
    public static int initId = 1006;
    //添加数据
    public int save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        departmentDao = new DepartmentDao();
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
        return  initId;
    }
    //查询全员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工
    public  void  delEmployeeById(Integer id){
        employees.remove(id);
    }
}
