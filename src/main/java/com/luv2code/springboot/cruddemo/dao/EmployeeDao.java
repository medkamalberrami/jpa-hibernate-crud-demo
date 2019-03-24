package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findListAllEmployee();
	
	public Employee findEmployeeById(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployeeById(int id);

}
