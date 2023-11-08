package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Candidate;

public interface CandidateServiceInterface {

	public boolean addNewCandidate(Candidate candidate);
	
    public Candidate UpdateCandidate(Candidate candidate);
    
    public boolean deleteCandidate(String candidateId);
    
    public Candidate getCandidateByCandidateId(String candidateId);
    
    public List<Candidate> getAllCandidate();
}
