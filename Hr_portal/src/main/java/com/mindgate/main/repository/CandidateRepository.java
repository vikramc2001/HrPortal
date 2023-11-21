package com.mindgate.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Candidate;

@Repository
public class CandidateRepository implements CandidateRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String Insert_New_Candidate = "insert into candidate_details values('CAN'||candidate_sequence.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final static String Update_existing_Candidate = "update candidate_details set candidate_name=?,skill_1=?, skill_2=?, skill_3=?,title=?, qualification=?,passed_out_year=?,interview_date=?,experience=?,grade=?,phone=?,email=?,apply_date=?,job_id=? where candidate_id=?";
	private final static String Delete_existing_Candidate = "delete from  candidate_details where candidate_id =?";
	private final static String Select_all_Candidate = "select * from candidate_details c,job_description j,employee_details e,project_details p where c.job_id=j.job_id(+) and j.employee_id=e.employee_id and j.project_id=p.project_id(+)";
	private final static String Select_one_Candidate = "select * from candidate_details c,job_description j,employee_details e,project_details p where c.job_id=j.job_id(+) and j.employee_id=e.employee_id and j.project_id=p.project_id(+) and candidate_id =?";
	private final static String Get_Application_Candidate="select * from candidate_details c,job_description j,employee_details e,project_details p where c.job_id=j.job_id(+) and j.employee_id=e.employee_id(+) and j.project_id=p.project_id(+) and c.job_id =?";

	 private final static String Get_Candidate_status="select * from candidate_details c,job_description j,employee_details e,project_details p where c.job_id=j.job_id(+) and j.employee_id=e.employee_id(+) and j.project_id=p.project_id(+) and c.status=?";
	 
	 private final static String Get_Skill_Match="select * from candidate_details c,job_description j,employee_details e,project_details p where c.job_id=j.job_id(+) and j.employee_id=e.employee_id and j.project_id=p.project_id(+) and ? in(c.skill_1,c.skill_2,c.skill_3) and ? in (c.skill_1,c.skill_2,c.skill_3) and c.title=?";
	@Override
	public boolean addNewCandidate(Candidate candidate) {
		// TODO Auto-generated method stub

		Object[] parameters = { candidate.getCandidateName(),candidate.getSkill1(),candidate.getSkill2(),candidate.getSkill3() ,
				candidate.getTitle(), candidate.getQualification(), candidate.getPassedOutYear(), candidate.getInterviewDate(),
				candidate.getExperience(), candidate.getGrade(), candidate.getPhone(), candidate.getEmail(),
				candidate.getApplyDate(),candidate.getStatus(), candidate.getJobId(), };
		int rowcount=jdbcTemplate.update(Insert_New_Candidate, parameters);
		if(rowcount>0)
			return true;
		return false;

	}

	@Override
	public Candidate UpdateCandidate(Candidate candidate) {
		Object[] parameters = { candidate.getCandidateName(), candidate.getSkill1(),candidate.getSkill2(),candidate.getSkill3(),candidate.getTitle(), candidate.getQualification(),
				candidate.getPassedOutYear(), candidate.getInterviewDate(), candidate.getExperience(),
				candidate.getGrade(), candidate.getPhone(), candidate.getEmail(), candidate.getApplyDate(),
				candidate.getJobId(), candidate.getCandidateId() };
		int rowcount = jdbcTemplate.update(Update_existing_Candidate, parameters);
		if (rowcount > 0) {
			return getCandidateByCandidateId(candidate.getCandidateId());
		}
		return null;
	}

	@Override
	public boolean deleteCandidate(String candidateId) {
		int rowcount = jdbcTemplate.update(Delete_existing_Candidate, candidateId);
		if (rowcount > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Candidate getCandidateByCandidateId(String candidateId) {
		CandidateRowMapper candidateRowMapper = new CandidateRowMapper();
		Candidate candidate = jdbcTemplate.queryForObject(Select_one_Candidate, candidateRowMapper, candidateId);
		return candidate;
	}

	@Override
	public List<Candidate> getAllCandidate() {
		// TODO Auto-generated method stub
		CandidateRowMapper candidateRowMapper = new CandidateRowMapper();
		return jdbcTemplate.query(Select_all_Candidate, candidateRowMapper);
	}
	
	public List<Candidate> getCandidateApplication(String jobId){
		
		CandidateRowMapper candidateRowMapper = new CandidateRowMapper();
		return jdbcTemplate.query(Get_Application_Candidate,candidateRowMapper,jobId);
	}
	
	public List<Candidate> getCandidateByStatus(String status){
		CandidateRowMapper candidateRowMapper = new CandidateRowMapper();
		return jdbcTemplate.query(Get_Candidate_status,candidateRowMapper,status);
		
	}
	public List<Candidate> getMatchSkill(Candidate candidate){
		CandidateRowMapper candidateRowMapper = new CandidateRowMapper();
		Object[] parameter= {candidate.getSkill1(),candidate.getSkill2(),candidate.getTitle()};
		return jdbcTemplate.query(Get_Skill_Match,candidateRowMapper,parameter);
		
	}

}
