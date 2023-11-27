package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Employee;
import com.mindgate.main.domain.Job;
import com.mindgate.main.domain.Project;

public class JobRowMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet rs, int rowNum) throws SQLException {

		String jobId = rs.getString("job_id");
		String title = rs.getString("title");
		String qualification = rs.getString("qualification");
		String skill1 = rs.getString("skill_1");
		String skill2 = rs.getString("skill_2");
		String skill3 = rs.getString("skill_3");
		String projectId = rs.getString("project_id");
		String employeeId = rs.getString("employee_id");
		int requiredEmployees = rs.getInt("required_employees");
		String status = rs.getString("status");

//		String projectId=rs.getString("project_id");
		String projectName = rs.getString("project_name");
		Date startDate = rs.getDate("start_date");
		Date endDate = rs.getDate("end_date");
		double budget = rs.getDouble("budget");

		Project project = new Project(projectId, projectName, startDate, endDate, budget);

//		String employeeId = rs.getString("employee_id");
		String password = rs.getString("password");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String gender = rs.getString("gender");
		long phoneNo = rs.getLong("phone_no");
		String employeeemail = rs.getString("email");
		Date dateOfBirth = rs.getDate("date_of_birth");
		String designation = rs.getString("designation");
		String employeeskill1 = rs.getString("SKILL1");
		String employeeskill2 = rs.getString("SKILL2");
		String employeeskill3 = rs.getString("SKILL3");
		double salary = rs.getDouble("salary");
//		String projectId = rs.getString("PROJECT_ID");
		String managerId = rs.getString("manager_id");

		Employee employee = new Employee(employeeId, password, firstName, lastName, gender, phoneNo, employeeemail,
				dateOfBirth, designation, employeeskill1, employeeskill2, employeeskill3, salary, projectId, project,
				managerId);

		Job job = new Job(jobId, title, qualification, skill1, skill2, skill3, projectId, employeeId, requiredEmployees,
				status, project, employee);
		return job;
	}
}
