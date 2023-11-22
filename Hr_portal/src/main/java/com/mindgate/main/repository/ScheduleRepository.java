package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Schedule;

@Repository
public class ScheduleRepository implements ScheduleRepositoryInterface {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String INSERT_NEW_SCHEDULE = "insert into scheduled_details values('SCH'||scheduled_sequence.NEXTVAL,?,?,?,?,?)";
	private final static String UPDATE_EXISTING_SCHEDULE="update scheduled_details set candidate_id=?,interviewer_id=?,interview_date=?,interview_status=?,assessment_id=? where schedule_id=?";
	private final static String DELETE_EXISTING_SCHEDULE="delete from scheduled_details where schedule_id=?";
	private final static String SELECT_ALL_SCHEDULE ="SELECT * FROM scheduled_details s,assessment_details a,candidate_details c,job_description j,employee_details e,project_details p where s.assessment_id = a.assessment_id and s.candidate_id = c.candidate_id and c.job_id = j.job_id and j.project_id = p.project_id and j.employee_id=e.employee_id";
	private final static String SELECT_ONE_SCHEDULE="SELECT * FROM scheduled_details s,assessment_details a,candidate_details c,job_description j,employee_details e,project_details p where s.assessment_id = a.assessment_id and s.candidate_id = c.candidate_id and c.job_id = j.job_id and j.project_id = p.project_id and j.employee_id=e.employee_id and schedule_id=?";

	@Override
	public boolean addNewSchedule(Schedule schedule) {
		Object []parameters={
				schedule.getCandidateId(),
				schedule.getInterviewerId(),
				schedule.getInterviewDate(),
				schedule.getInterviewStatus(),
				schedule.getAssessmentId()
		};
		int rowCount=jdbcTemplate.update(INSERT_NEW_SCHEDULE, parameters);
		if(rowCount>0)
			return true;
		return false;
	}

	@Override
	public Schedule updateSchedule(Schedule schedule) {
		Object []parameters={
				schedule.getCandidateId(),
				schedule.getInterviewerId(),
				schedule.getInterviewDate(),
				schedule.getInterviewStatus(),
				schedule.getAssessmentId(),
				schedule.getScheduleId()
		};
		int rowCount=jdbcTemplate.update(UPDATE_EXISTING_SCHEDULE, parameters);
		if(rowCount>0)
			return getScheduleByScheduleId(schedule.getScheduleId());
		return null;
	}

	@Override
	public boolean deleteSchedule(String scheduleId) {
		int rowCount=jdbcTemplate.update(DELETE_EXISTING_SCHEDULE, scheduleId);
		if(rowCount>0)
			return true;
		return false;
	}

	@Override
	public Schedule getScheduleByScheduleId(String scheduleId) {
		ScheduleRowMapper scheduleRowMapper=new ScheduleRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_SCHEDULE, scheduleRowMapper, scheduleId);
	}

	@Override
	public List<Schedule> getAllSchedules() {
		ScheduleRowMapper scheduleRowMapper=new ScheduleRowMapper();
		return jdbcTemplate.query(SELECT_ALL_SCHEDULE, scheduleRowMapper);
	}

}
