package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Employee;

@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String INSERT_NEW_EMPLOYEE = "insert into employee_details values('EMP'||employee_sequence.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final static String UPDATE_EXISTING_EMPLOYEE="update employee_details set password=?,first_name=?,last_name=?,gender=?,phone_no=?,email=?,date_of_birth=?,designation=?,skill1=?,skill2=?,skill3=?,salary=?,project_id=?,manager_id=? where employee_id=?";
	private final static String DELETE_EXISTING_EMPLOYEE="delete from employee_details where employee_id=?";
	private final static String SELECT_ALL_EMPLOYEE = "select * from employee_details,project_details where employee_details.project_id=project_details.project_id(+)";
	private final static String SELECT_ONE_EMPLOYEE="select * from employee_details,project_details where employee_details.project_id=project_details.project_id(+) and employee_id=?";
   //private final static String login_Employee="select * from employee_details where employee_id=? and password=?";
	
	private final static String GetWorkBench="select * from employee_details ,project_details where employee_details.project_id=project_details.project_id(+) and employee_details.project_id is NUll and designation=? and ? in (skill1,skill2,skill3) and ? in (skill1,skill2,skill3) ";
	@Override
	public boolean addNewEmployee(Employee employee) {
		Object []parameters={
				employee.getPassword(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getGender(),
				employee.getPhoneNo(),
				employee.getEmail(),
				employee.getDateOfBirth(),
				employee.getDesignation(),
				employee.getSkill1(),
				employee.getSkill2(),
				employee.getSkill3(),
				employee.getSalary(),
				employee.getProjectId(),
				employee.getManagerId(),
				
		};
		int rowCount=jdbcTemplate.update(INSERT_NEW_EMPLOYEE, parameters);
		if(rowCount>0)
			return true;
		return false;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Object []parameters={
				employee.getPassword(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getGender(),
				employee.getPhoneNo(),
				employee.getEmail(),
				employee.getDateOfBirth(),
				employee.getDesignation(),
				employee.getSkill1(),
				employee.getSkill2(),
				employee.getSkill3(),
				employee.getSalary(),
				employee.getProjectId(),
				employee.getManagerId(),
				employee.getEmployeeId(),
				
				
		};
		int rowCount=jdbcTemplate.update(UPDATE_EXISTING_EMPLOYEE, parameters);
		if(rowCount>0)
			return getEmployeeByEmployeeId(employee.getEmployeeId());
		return null;
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		int rowCount=jdbcTemplate.update(DELETE_EXISTING_EMPLOYEE, employeeId);
		if(rowCount>0)
			return true;
		return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(String employeeId) {
		EmployeeRowMapper employeeRowMapper=new EmployeeRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_EMPLOYEE, employeeRowMapper, employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		return jdbcTemplate.query(SELECT_ALL_EMPLOYEE, employeeRowMapper);
	}

	@Override
	public List<Employee> getWorkBenchEmployee(Employee employee) {
		Object []parameter= {employee.getDesignation(),employee.getSkill1(),employee.getSkill2()};
		EmployeeRowMapper employeeRowMapper=new EmployeeRowMapper();
		return jdbcTemplate.query(GetWorkBench, employeeRowMapper ,parameter);
	}

	

}
