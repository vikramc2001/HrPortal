package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Employee;

public interface EmployeeServiceInterface {

	boolean addNewEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	boolean deleteEmployee(String employeeId);
	
	Employee getEmployeeByEmployeeId(String employeeId);
	
	List<Employee> getAllEmployees();
	
	public Employee loginDetails(Employee employee);
	
	
	public List<Employee> getWorkBenchEmployee(Employee employee);
		
	
}
