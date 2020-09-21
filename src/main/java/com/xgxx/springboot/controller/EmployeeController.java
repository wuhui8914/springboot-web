package com.xgxx.springboot.controller;

import com.xgxx.springboot.dao.DepartmentDao;
import com.xgxx.springboot.dao.EmployeeDao;
import com.xgxx.springboot.entities.Department;
import com.xgxx.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.Collection;
import java.util.Date;

/**
 * @ClassName: EmployeeController
 * @Description: TODO
 * @Author dongxin
 * @Date 2020/7/9 0009 下午 2:49
 * @Version: 1.0
 **/
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

   //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String getEmpList(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeplates 默认就会拼串
        return "emp/list";
    }

    //跳转员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面，查询所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        System.out.println(departments);
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加方法
    //springMVC自动将请求参数和入参对象的属性进行--绑定：要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println(employee.getLastName());
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址，  /代表当前项目路径
        //forward: 表示转发到一个地址
        return "redirect:/emps";
    }


    //来到修改页面，查询当前员工，在当前页面显示
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);//dea自动补全返回类型及变量快捷键 ctrl+alt+v
        model.addAttribute("emp",employee);
        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面（当前项目add是一个修改添加二合一的页面）
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updataEmps(Employee employee){
        employeeDao.update(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public  String deletetEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";

    }



}