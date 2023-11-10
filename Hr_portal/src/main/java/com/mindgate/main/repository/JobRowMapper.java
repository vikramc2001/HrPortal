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
		
		ProjectRowMapper projectRowMapper=new ProjectRowMapper();
		Project project=projectRowMapper.mapRow(rs, rowNum);
		
		EmployeeRowMapper employeeRowMapper=new EmployeeRowMapper();
		Employee employee=employeeRowMapper.mapRow(rs, rowNum);
		
		Job job=new Job(jobId, title, qualification, skill1, skill2, skill3, projectId, employeeId, requiredEmployees, status, project, employee);
		return job;
	}
}
