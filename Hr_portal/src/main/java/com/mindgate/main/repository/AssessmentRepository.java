package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Assessment;

@Repository
public class AssessmentRepository implements AssessmentRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String Insert_New_Assessment = "insert into assessment_details values(assessment_sequence.nextVal,?,?,?,?,?)";
	private final static String Update_existing_Assessment = "update assessment_details  set round_1=?,round_2=?,round_3=?,status=?,candidate_id=? where assessment_id=?";
	private final static String Delete_existing_Assessment = "delete from assessment_details where assessment_Id=?";
	private final static String Select_one_Assessment = "select * from ASSESSMENT_DETAILS a,CANDIDATE_DETAILS c,JOB_DESCRIPTION j,PROJECT_DETAILS p where a.CANDIDATE_ID=c.CANDIDATE_ID(+) and c.job_id=j.job_id(+) and j.project_id=p.project_id(+) and assessment_Id=?";
	private final static String Select_all_Assessment = "select * from ASSESSMENT_DETAILS a,CANDIDATE_DETAILS c,JOB_DESCRIPTION j,PROJECT_DETAILS p where a.CANDIDATE_ID=c.CANDIDATE_ID(+) and c.job_id=j.job_id(+) and j.project_id=p.project_id(+)";

	@Override
	public boolean addNewAssessment(Assessment assessment) {
		Object[] param = { 
				assessment.getRound1(),
				assessment.getRound2(),
				assessment.getRound3(), 
				assessment.getStatus(),
				assessment.getCandidateId()
				};
	     int result=jdbcTemplate.update(Insert_New_Assessment, param);
		 if(result>0)
			 return true;
			else {
				return false;
			}
	 }

	@Override
	public Assessment updateAssessment(Assessment assessment) {
		Object[] parameters = {
				assessment.getRound1(),
				assessment.getRound2(),
				assessment.getRound3(),
				assessment.getStatus(),
				assessment.getCandidateId(),
				assessment.getAssessmentId()
				};
		int rowcount = jdbcTemplate.update(Update_existing_Assessment, parameters);
		if (rowcount > 0) {
			return getOneAssessmentID(assessment.getAssessmentId());
		}

		return null;

	}

	@Override
	public boolean deleteAssessment(String assessmentId) {

	    jdbcTemplate.update(Delete_existing_Assessment, assessmentId);
		return true;
		}

	@Override
	public Assessment getOneAssessmentID(String assessmentId) {

		AssessmentRowMapper assessmentRowMapper = new AssessmentRowMapper();
        Assessment assessment = jdbcTemplate.queryForObject(
        		                Select_one_Assessment, assessmentRowMapper, assessmentId);
		return assessment;
	}

	@Override
	public List<Assessment> getAllAssessment() {
		
		AssessmentRowMapper assessmentRowMapper = new AssessmentRowMapper();
        return jdbcTemplate.query(Select_all_Assessment, assessmentRowMapper);

	}

}
