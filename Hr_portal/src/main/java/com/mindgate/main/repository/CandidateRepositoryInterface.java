package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Assessment;
import com.mindgate.main.domain.Candidate;

public interface CandidateRepositoryInterface {

	
	public boolean addNewCandidate(Candidate candidate);
	
    public Candidate UpdateCandidate(Candidate candidate);
    
    public boolean deleteCandidate(String candidateId);
    
    public Candidate getCandidateByCandidateId(String candidateId);
    
    public List<Candidate> getAllCandidate();
    public List<Candidate> getCandidateApplication(String jobId);
    public List<Candidate> getCandidateByStatus(String status);
	public List<Candidate> getMatchSkill(Candidate candidate);
	
	public boolean updateResume(Candidate candidate);
	public List<Candidate> getSelectedCandidate();
	
}
