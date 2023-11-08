package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Job;
import com.mindgate.main.repository.JobRepositoryInterface;

@Service
public class JobService implements JobServiceInterface {
	
	@Autowired
	private JobRepositoryInterface jobRepositoryInterface;
	
	@Override
	public boolean addJobDescription(Job job) {
		// TODO Auto-generated method stub
		return jobRepositoryInterface.addJobDescription(job);
	}

	@Override
	public Job updateJob(Job job) {
		// TODO Auto-generated method stub
		return jobRepositoryInterface.updateJob(job);
	}

	@Override
	public boolean deleteJob(String jobId) {
		// TODO Auto-generated method stub
		return jobRepositoryInterface.deleteJob(jobId);
	}

	@Override
	public Job getOneJob(String jobId) {
		// TODO Auto-generated method stub
		return jobRepositoryInterface.getOneJob(jobId);
	}

	@Override
	public List<Job> getAllJob() {
		// TODO Auto-generated method stub
		return jobRepositoryInterface.getAllJob();
	}

}
