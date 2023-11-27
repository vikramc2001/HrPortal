package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Project;

public class ProjectRowMapper implements RowMapper<Project>{

	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		String projectId=rs.getString("project_id");
		String projectName=rs.getString("project_name");
		Date startDate=rs.getDate("start_date");
		Date endDate=rs.getDate("end_date");
		double budget=rs.getDouble("budget");
		
		Project project=new Project(projectId, projectName, startDate, endDate, budget);
		
		return project ;
			
	}

}
