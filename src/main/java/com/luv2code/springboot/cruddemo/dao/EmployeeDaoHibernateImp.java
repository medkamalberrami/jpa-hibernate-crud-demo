package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImp implements EmployeeDao {

	// define field for entityManager
	private EntityManager entityManager;

	// set up constructor injection
	public EmployeeDaoHibernateImp(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findListAllEmployee() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute a query and get result list
		List<Employee> listEmployee = theQuery.getResultList();

		// return the result

		return listEmployee;
	}

	@Override
	public Employee findEmployeeById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);

		Employee theEmployee = currentSession.get(Employee.class, id);
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
	}

}
