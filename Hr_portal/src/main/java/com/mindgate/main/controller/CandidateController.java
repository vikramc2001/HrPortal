package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Candidate;
import com.mindgate.main.service.CandidateServiceInterface;

@RestController
@CrossOrigin("*")
@RequestMapping("candidateApi")
public class CandidateController {

	@Autowired
	private CandidateServiceInterface candidateServiceInterface;
	
	
    @RequestMapping(value="candidate" ,method=RequestMethod.POST)
	public boolean addNewCandidate(@RequestBody Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateServiceInterface.addNewCandidate(candidate);
	}

    @RequestMapping(value="candidate" ,method=RequestMethod.PUT)
	public Candidate UpdateCandidate(@RequestBody Candidate candidate) {
		// TODO Auto-generated method stub
		return candidateServiceInterface.UpdateCandidate(candidate);
	}

//	http://localhost:8081/candidateApi/candidate/CAN4001
	@RequestMapping(value="candidate/{candidateId}" ,method=RequestMethod.DELETE)
	public boolean deleteCandidate(@PathVariable String candidateId) {
		// TODO Auto-generated method stub
		return candidateServiceInterface.deleteCandidate(candidateId);
	}

//	http://localhost:8081/candidateApi/candidate/CAN4001
	@RequestMapping(value="candidate/{candidateId}" ,method=RequestMethod.GET)
	public Candidate getCandidateByCandidateId(@PathVariable String candidateId) {
		// TODO Auto-generated method stub
		return candidateServiceInterface.getCandidateByCandidateId(candidateId);
	}
	
//	http://localhost:8081/candidateApi/candidates
	@RequestMapping(value="candidates" ,method=RequestMethod.GET)
	public List<Candidate> getAllCandidate() {
		// TODO Auto-generated method stub
		return candidateServiceInterface.getAllCandidate();
	}
	// http://localhost:8081/candidateApi/getApplication
	@RequestMapping(value="getApplication/{jobId}" ,method=RequestMethod.GET)
	public List<Candidate> getCandidateApplication(@PathVariable String jobId){
		return candidateServiceInterface.getCandidateApplication(jobId);
	}

	// http://localhost:8081/candidateApi/getcandidateBy
		@RequestMapping(value="getcandidateBy/{status}" ,method=RequestMethod.GET)
		public List<Candidate> getCandidateByStatus(@PathVariable String status){
			return candidateServiceInterface.getCandidateByStatus(status);
		}

}
