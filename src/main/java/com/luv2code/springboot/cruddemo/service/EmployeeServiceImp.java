package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDao;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImp(@Qualifier("employeeDaoJpaImp") EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findListAllEmployee() {
		return employeeDao.findListAllEmployee();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int idEmployee) {
		return employeeDao.findEmployeeById(idEmployee);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {

		employeeDao.saveEmployee(theEmployee);

	}

	@Override
	@Transactional
	public void deleteEmployeeById(int idEmployee) {

		employeeDao.deleteEmployeeById(idEmployee);

	}

}
