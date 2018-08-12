package com.example.springbootwebrestfulcrud.controller;

import com.example.springbootwebrestfulcrud.dao.DepartmentDao;
import com.example.springbootwebrestfulcrud.dao.EmployeeDao;
import com.example.springbootwebrestfulcrud.entities.Department;
import com.example.springbootwebrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping(value = "/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放到请求域中
        model.addAttribute("emps", employees);
        //themeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }

    //员工添加页面
    @GetMapping(value = "/emp")
    public String toAddPage(Model model) {
        //查出所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/edit";
    }

    //员工添加
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //来到修改页面
    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/edit";
    }

    //员工修改
    @PutMapping(value = "/emp")
    public String EditEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
