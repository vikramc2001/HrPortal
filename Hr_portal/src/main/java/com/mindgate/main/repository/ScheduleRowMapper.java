package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Assessment;
import com.mindgate.main.domain.Candidate;
import com.mindgate.main.domain.Employee;
import com.mindgate.main.domain.Job;
import com.mindgate.main.domain.Project;
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
		
//		String assessmentId = rs.getString("assessment_Id");
		String round1 = rs.getString("round_1");
		String round2 = rs.getString("round_2");
		String round3 = rs.getString("round_3");
		String status = rs.getString("status");
//		String candidateId = rs.getString("candidate_Id");
		
//		String candidateId = rs.getString("candidate_id");
		String candidateName = rs.getString("candidate_name");
		String skill1 = rs.getString("skill_1");
		String skill2 = rs.getString("skill_2");
		String skill3 = rs.getString("skill_3");
		String title = rs.getString("title");
		String qualification = rs.getString("qualification");
		String passedOutYear = rs.getString("passed_out_year");
		String experience = rs.getString("experience");
		String grade = rs.getString("grade");
		Long phone = rs.getLong("phone");
		String email = rs.getString("email");
		Date applyDate = rs.getDate("apply_date");
		String candidatestatus = rs.getString("status");
		String jobId = rs.getString("job_id");
		byte[] resume = rs.getBytes("resume");

//		String jobId = rs.getString("job_id");
		String jobtitle = rs.getString("title");
		String jobqualification = rs.getString("qualification");
		String jobskill1 = rs.getString("skill_1");
		String jobskill2 = rs.getString("skill_2");
		String jobskill3 = rs.getString("skill_3");
		String projectId = rs.getString("project_id");
		String employeeId = rs.getString("employee_id");
		int requiredEmployees = rs.getInt("required_employees");
		String jobstatus = rs.getString("status");

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

		Job job = new Job(jobId, jobtitle, jobqualification, jobskill1, jobskill2, jobskill3, projectId, employeeId,
				requiredEmployees, jobstatus, project, employee);
		
		Candidate candidate = new Candidate(candidateId, candidateName, skill1, skill2, skill3, title, qualification,
				passedOutYear, experience, grade, phone, email, applyDate, jobId, candidatestatus, resume, job);

		Assessment assessment = new Assessment(assessmentId, round1, round2, round3, status, candidateId, candidate);

		Schedule schedule = new Schedule(scheduleId, candidateId, candidate, interviewerId, interviewDate,
				interviewStatus, assessmentId, assessment);
		return schedule;
	}

}
