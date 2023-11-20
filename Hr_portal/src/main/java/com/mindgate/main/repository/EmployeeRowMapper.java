package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Employee;
import com.mindgate.main.domain.Project;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		String employeeId = rs.getString("employee_id");
		String password = rs.getString("password");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String gender = rs.getString("gender");
		long phoneNo = rs.getLong("phone_no");
		String email = rs.getString("email");
		Date dateOfBirth = rs.getDate("date_of_birth");
		String designation = rs.getString("designation");
		String skill1=rs.getString("SKILL1");
		String skill2=rs.getString("SKILL2");
		String skill3=rs.getString("SKILL3");
		double salary = rs.getDouble("salary");
		String projectId = rs.getString("PROJECT_ID");
		String managerId = rs.getString("manager_id");
		
		
		
	

		ProjectRowMapper rowMapper=new ProjectRowMapper();
		Project project=rowMapper.mapRow(rs, rowNum);
		
		Employee employee=new Employee(employeeId, password, firstName, lastName, gender, phoneNo, email, dateOfBirth, designation, skill1, skill2, skill3, salary, projectId, project, managerId);
		
		return employee;
	}

}
