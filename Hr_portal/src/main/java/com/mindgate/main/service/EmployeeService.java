package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Employee;
import com.mindgate.main.repository.EmployeeRepositoryInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepositoryInterface employeeRepositoryInterface;
	
	@Override
	public boolean addNewEmployee(Employee employee) {
		
		return employeeRepositoryInterface.addNewEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepositoryInterface.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		
		return employeeRepositoryInterface.deleteEmployee(employeeId);
	}

	@Override
	public Employee getEmployeeByEmployeeId(String employeeId) {
		
		return employeeRepositoryInterface.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepositoryInterface.getAllEmployees();
	}

	@Override
	public Employee loginDetails(Employee employee) {
		String employeeId = employee.getEmployeeId();
		String password = employee.getPassword();
		Employee oldEmployee = employeeRepositoryInterface.getEmployeeByEmployeeId(employeeId);
		
		if(employeeId.equals(oldEmployee.getEmployeeId()))
				{
				if( password.equals(oldEmployee.getPassword())){
					return oldEmployee;
				
				}
		}
		 System.out.println("invalid data");
		return null;
	}

	@Override
	public List<Employee> getWorkBenchEmployee(String designation) {
		
		return employeeRepositoryInterface.getWorkBenchEmployee(designation);
	}



}
