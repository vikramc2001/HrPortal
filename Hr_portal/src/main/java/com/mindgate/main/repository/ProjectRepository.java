package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Project;

@Repository
public class ProjectRepository implements ProjectRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String Delete_existing_project = "delete from project_details where PROJECT_ID =?";
	private final static String Insert_New_project = "insert into project_details  values('PRO'||project_sequence.nextVal,?,?,?,?)";
	private final static String Select_one_project = "select * from project_details  where PROJECT_ID =?";
	private final static String Select_all_project = "select * from project_details";
	private final static String Update_existing_project = "update project_details set project_name=?,start_date=?,end_date=?,budget=? where PROJECT_ID=?";

	@Override
	public boolean addNewProject(Project projectDetails) {

		Object[] parameters = { projectDetails.getProjectName(), projectDetails.getStartDate(),
				projectDetails.getEndDate(), projectDetails.getBudget() };
		jdbcTemplate.update(Insert_New_project, parameters);

		return true;
	}

	@Override
	public Project UpdateProject(Project projectDetails) {
		Object[] parameters = { projectDetails.getProjectName(), projectDetails.getStartDate(),
				projectDetails.getEndDate(), projectDetails.getBudget(), projectDetails.getProjectId() };
		int rowcount = jdbcTemplate.update(Update_existing_project, parameters);
		if (rowcount > 0) {
			return getprojectByprojectId(projectDetails.getProjectId());
		}

		return null;
	}

	@Override
	public boolean deleteProject(String projectId) {
		int rowcount = jdbcTemplate.update(Delete_existing_project, projectId);
		if (rowcount > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Project getprojectByprojectId(String projectId) {
		ProjectRowMapper projectRowMapper = new ProjectRowMapper();
		Project projectDetails = jdbcTemplate.queryForObject(Select_one_project, projectRowMapper, projectId);
		return projectDetails;

	}

	@Override
	public List<Project> getAllproject() {
		ProjectRowMapper projectRowMapper = new ProjectRowMapper();
		return jdbcTemplate.query(Select_all_project, projectRowMapper);

	}

}
