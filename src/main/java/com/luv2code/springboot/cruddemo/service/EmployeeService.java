package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findListAllEmployee();

	public Employee findEmployeeById(int idEmployee);

	public void saveEmployee(Employee theEmployee);

	public void deleteEmployeeById(int idEmployee);

}
