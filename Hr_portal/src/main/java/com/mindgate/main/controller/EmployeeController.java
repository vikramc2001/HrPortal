package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Employee;
import com.mindgate.main.service.EmployeeServiceInterface;

@RestController
@CrossOrigin("*")
@RequestMapping("employeeapi")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	@RequestMapping(value="employees",method = RequestMethod.GET)
	public List<Employee> allEmployees(){
		return employeeServiceInterface.getAllEmployees();
	}
	
	@RequestMapping(value="add/employee",method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody Employee employee) {
		return employeeServiceInterface.addNewEmployee(employee);
	}
	
	@RequestMapping(value="getone/{employeeId}" ,method = RequestMethod.GET)
	public Employee getEmployeeByEmployeeId(@PathVariable String employeeId) {
		return employeeServiceInterface.getEmployeeByEmployeeId(employeeId);
	}
	
	@RequestMapping(value = "delete/{employeeId}",method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable String employeeId) {
		return employeeServiceInterface.deleteEmployee(employeeId);
	}
	
	@RequestMapping(value = "update/employee" ,method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeServiceInterface.updateEmployee(employee);
	}
	@RequestMapping(value="loginvalidation" ,method=RequestMethod.POST)
	public Employee LoginDetails(@RequestBody Employee employee) {
		return employeeServiceInterface.loginDetails(employee);
	}
	@RequestMapping(value="getworkbench/{designation}",method=RequestMethod.GET)
	public List<Employee> getWorkBenchEmployee(@PathVariable String designation) {
		return employeeServiceInterface.getWorkBenchEmployee(designation);
	}
}
