package com.mindgate.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.main.domain.Assessment;
import com.mindgate.main.domain.Candidate;

public class AssessmentRowMapper implements RowMapper<Assessment> {

	@Override
	public Assessment mapRow(ResultSet rs, int rowNum) throws SQLException {
		String assessmentId = rs.getString("assessment_Id");
		String round1 = rs.getString("round_1");
		String round2 = rs.getString("round_2");
		String round3 = rs.getString("round_3");
		String status = rs.getString("status");
		String candidateId = rs.getString("candidate_Id");

		CandidateRowMapper candidateRowMapper=new CandidateRowMapper();
		Candidate candidate=candidateRowMapper.mapRow(rs, rowNum);
		
		Assessment assessment=new Assessment(assessmentId, round1, round2, round3, status, candidateId, candidate);
		return assessment;
	}

}
