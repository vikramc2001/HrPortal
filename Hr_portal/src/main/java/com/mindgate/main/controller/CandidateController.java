package com.mindgate.main.controller;

import java.io.IOException;
import org.springframework.util.StringUtils;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		@RequestMapping(value="getmatchSkill" ,method=RequestMethod.POST)
		public List<Candidate> getMatchSkill(@RequestBody Candidate candidate){
			return candidateServiceInterface.getMatchSkill(candidate);
		}
		
		@RequestMapping(value = "upload/{candidateId}", method = RequestMethod.PUT)
	    public boolean uploadResume(@PathVariable String candidateId , @RequestParam("file") MultipartFile file) {
	        Candidate candidate = new Candidate();
	        candidate.setCandidateName(StringUtils.cleanPath(file.getOriginalFilename()));
	        candidate.setCandidateId(candidateId);
	        try {
	            candidate.setResume(file.getBytes());
	        } catch (IOException e) {
	            System.out.println("Exception while file upload");
	        }
	        return candidateServiceInterface.updateResume(candidate);
	    }
		@RequestMapping(value = "/files/{candidateId}")
	    public ResponseEntity<byte[]> getFile(@PathVariable String candidateId) {
	        Candidate candidate = candidateServiceInterface.getCandidateByCandidateId(candidateId);
	        return ResponseEntity.ok()
	                .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + candidate.getCandidateName() + "\"")
	                .body(candidate.getResume());
	    }
}
