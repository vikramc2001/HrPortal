package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Candidate;
import com.mindgate.main.repository.CandidateRepositoryInterface;

@Service
public class CandidateService implements CandidateServiceInterface {

	@Autowired
	private CandidateRepositoryInterface candidateRepositoryInterface;
	@Override
	public boolean addNewCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.addNewCandidate(candidate);
	}

	@Override
	public Candidate UpdateCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.UpdateCandidate(candidate);
	}

	@Override
	public boolean deleteCandidate(String candidateId) {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.deleteCandidate(candidateId);
	}

	@Override
	public Candidate getCandidateByCandidateId(String candidateId) {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.getCandidateByCandidateId(candidateId);
	}

	@Override
	public List<Candidate> getAllCandidate() {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.getAllCandidate();
	}

	@Override
	public List<Candidate> getCandidateApplication(String jobId) {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.getCandidateApplication(jobId);
	}

	@Override
	public List<Candidate> getCandidateByStatus(String status) {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.getCandidateByStatus(status);
	}

	@Override
	public List<Candidate> getMatchSkill(Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.getMatchSkill(candidate);
	}

	@Override
	public boolean updateResume(Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateRepositoryInterface.updateResume(candidate);
	}

}
