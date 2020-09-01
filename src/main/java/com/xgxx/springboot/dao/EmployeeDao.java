package com.xgxx.springboot.dao;

import java.util.Collection;

import com.xgxx.springboot.entities.Employee;
import com.xgxx.springboot.mapper.DepartmentMapper;
import com.xgxx.springboot.mapper.EmpLoyessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao {

//	private static Map<Integer, Employee> employees = null;

//	@Autowired
//	private DepartmentDao departmentDao;

	@Autowired
	EmpLoyessMapper empLoyessMapper;

	@Autowired
	DepartmentMapper departmentMapper;
	
//	static{
//		employees = new HashMap<Integer, Employee>();
//
//		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
//		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
//		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
//		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
//		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
//	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee){
		empLoyessMapper.insertEmployee(employee);
	}
	
	public Collection<Employee> getAll(){
		return empLoyessMapper.getEmployeeAll();
	}
	
	public Employee get(Integer id){
		return empLoyessMapper.getEmployeeId(id);
	}
	
	public void delete(Integer id){
		empLoyessMapper.deletetEmployeeById(id);
	}

	public void update(Employee employee){
		empLoyessMapper.updateEmployeeById(employee);
	}
}
