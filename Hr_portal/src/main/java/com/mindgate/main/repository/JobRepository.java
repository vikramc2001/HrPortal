package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Job;

@Repository
public class JobRepository implements JobRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String INSERT_NEW_JOB_DESCRIPTION = "insert into job_description values('JOB' || job_sequence.nextVal,?,?,?,?,?,?,?,?,?)";
	private final static String DELETE_EXISTING_JOB_DESCRIPTION = "delete from job_description where job_Id=?";
	private final static String UPDATE_JOB_DESCRIPTION = "update job_description set title=?,qualification=?,skill_1=?,skill_2=?,skill_3=?,project_id=?,employee_id=?,required_employees=?,status=? where job_id=?";
	private final static String SELECT_ALL_JOB = "select * from job_description j,employee_details e,project_details p where j.employee_id=e.employee_id(+) and j.project_id=p.project_id(+) and status not in 'Closed'";
	private final static String SELECT_ONE_JOB = "select * from job_description j,employee_details e,project_details p where j.employee_id=e.employee_id(+) and j.project_id=p.project_id(+) and job_id=?";

	private final static String SELECT_JOB_BY_TL = "select * from job_description j,employee_details e,project_details p where j.employee_id=e.employee_id(+) and j.project_id=p.project_id(+) and j.employee_id=?";
private final static String SELECT_PENDING_JOB = "select * from job_description j,employee_details e,project_details p where j.employee_id=e.employee_id(+) and j.project_id=p.project_id(+) and status  in 'Pending'";
    
private final static String SELECT_POST_JOB = "select * from job_description j,employee_details e,project_details p where j.employee_id=e.employee_id(+) and j.project_id=p.project_id(+) and status in 'post'";

	@Override
	public boolean addJobDescription(Job job) {
		Object[] parameters = { job.getTitle(), job.getQualification(), job.getSkill1(), job.getSkill2(),
				job.getSkill3(), job.getProjectId(), job.getEmployeeId(), job.getRequiredEmployees(), job.getStatus() };
		jdbcTemplate.update(INSERT_NEW_JOB_DESCRIPTION, parameters);
		return true;
	}

	@Override
	public Job updateJob(Job job) {
		Object[] parameters = { job.getTitle(), job.getQualification(), job.getSkill1(), job.getSkill2(),
				job.getSkill3(), job.getProjectId(), job.getEmployeeId(), job.getRequiredEmployees(), job.getStatus(),
				job.getJobId() };
		int rowCount = jdbcTemplate.update(UPDATE_JOB_DESCRIPTION, parameters);
		if (rowCount > 0)
			return getOneJob(job.getJobId());
		else
			return null;
	}

	@Override
	public boolean deleteJob(String jobId) {
		int rowCount = jdbcTemplate.update(DELETE_EXISTING_JOB_DESCRIPTION, jobId);
		if (rowCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public Job getOneJob(String jobId) {
		JobRowMapper jobRowMapper = new JobRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_JOB, jobRowMapper, jobId);
	}

	@Override
	public List<Job> getAllJob() {
		JobRowMapper jobMapper = new JobRowMapper();
		return jdbcTemplate.query(SELECT_ALL_JOB, jobMapper);
	}

	@Override
	public List<Job> getAllJobByEmployee(String employeeId) {
		JobRowMapper jobMapper = new JobRowMapper();
		return jdbcTemplate.query(SELECT_JOB_BY_TL, jobMapper, employeeId);
	}

	@Override
	public List<Job> getPendingJobDiscription() {
		JobRowMapper jobMapper = new JobRowMapper();
		return jdbcTemplate.query(SELECT_PENDING_JOB, jobMapper);
	}

	@Override
	public List<Job> getPostJobDiscription() {
		JobRowMapper jobMapper = new JobRowMapper();
		return jdbcTemplate.query(SELECT_POST_JOB, jobMapper);
	}
	


	 

	 
	
}
