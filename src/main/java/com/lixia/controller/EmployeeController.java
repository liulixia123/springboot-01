package com.lixia.controller;

import com.lixia.dao.DepartmentDao;
import com.lixia.dao.EmployeeDao;
import com.lixia.pojo.Department;
import com.lixia.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Resource
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        EmployeeDao employeeDao = new EmployeeDao();
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "emps/list";
    }
    //新增跳转页
    @GetMapping(value = "/emps/toAdd")
    public String toAdd(Model model){
        DepartmentDao departmentDao = new DepartmentDao();
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "emps/add";
    }
    //新增实现
    @PostMapping(value = "/emps/add")
    public String add(Employee employee){
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //修改跳转页
    @GetMapping(value = "/emps/toUpdate/{Id}")
    public String toUpdate(@PathVariable(value="Id") Integer id,Model model){
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        departmentDao = new DepartmentDao();
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "emps/edit";
    }
    //修改实现
    @PostMapping(value = "/emps/update")
    public  String update(Employee employee){
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //单个删除实现
    @PostMapping(value = "/emps/del")
    public String delete(@RequestParam("id")Integer id){
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.delEmployeeById(id);
        return "redirect:/emps";
    }
    //批量删除实现
    @PostMapping(value = "/emps/delAll")
    public String deleteAll(@RequestParam("ids") String ids){
        EmployeeDao employeeDao = new EmployeeDao();

        String[] idarr = ids.split(",");
        for(String id :idarr){
            employeeDao.delEmployeeById(Integer. parseInt(id));
        }
        return "redirect:/emps";
    }
}
