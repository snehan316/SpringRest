package com.sneha.springdemo.dao;

import java.util.List;

import com.sneha.springdemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
	

}
