package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Candidate;

public interface CandidateRepositoryInterface {

	
	public boolean addNewCandidate(Candidate candidate);
	
    public Candidate UpdateCandidate(Candidate candidate);
    
    public boolean deleteCandidate(String candidateId);
    
    public Candidate getCandidateByCandidateId(String candidateId);
    
    public List<Candidate> getAllCandidate();
}
