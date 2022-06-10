package com.sneha.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sneha.springdemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Employee> theQuery = session.createQuery("from Employee",Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	
	
	

}
