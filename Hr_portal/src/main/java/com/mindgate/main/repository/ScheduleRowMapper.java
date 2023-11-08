package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Assessment;
import com.mindgate.main.domain.Candidate;
import com.mindgate.main.domain.Schedule;

public class ScheduleRowMapper implements RowMapper<Schedule> {

	@Override
	public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
		String scheduleId = rs.getString("schedule_id");
		String candidateId = rs.getString("candidate_id");
		String interviewerId = rs.getString("interviewer_id");
		Date interviewDate = rs.getDate("interview_date");
		String interviewStatus = rs.getString("interview_status");
		String assessmentId = rs.getString("assessment_id");

		CandidateRowMapper candidateRowMapper=new CandidateRowMapper();
		Candidate candidate=candidateRowMapper.mapRow(rs, rowNum);
		
		AssessmentRowMapper assessmentRowMapper=new AssessmentRowMapper();
		Assessment assessment=assessmentRowMapper.mapRow(rs, rowNum);
		
		Schedule schedule = new Schedule(scheduleId, candidateId, candidate, interviewerId, interviewDate, interviewStatus, assessmentId, assessment);
		return schedule;
	}

}
