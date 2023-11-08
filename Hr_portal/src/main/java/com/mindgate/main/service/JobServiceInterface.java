package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Job;

public interface JobServiceInterface {

	public boolean addJobDescription(Job job);
	
	public Job updateJob(Job job);
	
	public boolean deleteJob(String jobId);
	
	public Job getOneJob(String jobId);
	
	public List<Job> getAllJob();
}
