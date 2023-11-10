package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Job;
import com.mindgate.main.service.JobServiceInterface;

@RestController
@RequestMapping("jobapi")
public class JobController {

	@Autowired
	private JobServiceInterface jobServiceInterface;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public boolean addNew(@RequestBody Job job) {
		return jobServiceInterface.addJobDescription(job);
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	public Job updateJob(@RequestBody Job job) {
		return jobServiceInterface.updateJob(job);
	}

	@RequestMapping(value = "delete/{jobId}", method = RequestMethod.DELETE)
	public boolean deleteJob(@PathVariable String jobId) {
		return jobServiceInterface.deleteJob(jobId);
	}

	@RequestMapping(value = "getone/{jobId}", method = RequestMethod.GET)
	public Job getOneJob(@PathVariable String jobId) {
		return jobServiceInterface.getOneJob(jobId);
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public List<Job> getAllJob() {
		return jobServiceInterface.getAllJob();
	}
	
	@RequestMapping(value = "getall/{employeeId}",method = RequestMethod.GET)
	public List<Job> getAllJobByEmployee(@PathVariable String employeeId) {
		// TODO Auto-generated method stub
		return jobServiceInterface.getAllJobByEmployee(employeeId);
	}
}
