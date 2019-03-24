package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoJpaImp implements EmployeeDao {

	// define field for entityManager
	private EntityManager entityManager;

	// set up constructor injection
	public EmployeeDaoJpaImp(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findListAllEmployee() {
		Query theQuery = entityManager.createQuery("from Employee");

		List<Employee> listEmployee = theQuery.getResultList();
		return listEmployee;
	}

	@Override
	public Employee findEmployeeById(int id) {

		Employee theEmployee = entityManager.find(Employee.class, id);

		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		Employee theEmployee = entityManager.merge(employee);

		employee.setId(theEmployee.getId());

	}

	@Override
	public void deleteEmployeeById(int id) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:EmployeId");

		theQuery.setParameter("EmployeId", id);
		theQuery.executeUpdate();

	}

}
