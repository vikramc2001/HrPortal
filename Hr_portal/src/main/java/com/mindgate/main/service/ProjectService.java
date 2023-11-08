package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Project;
import com.mindgate.main.repository.ProjectRepository;
@Service
public class ProjectService implements ProjectServiceInterface {
	@Autowired
	private ProjectRepository projectDetailsRepository;
	
	public ProjectService() {
		
	}

	@Override
	public boolean addNewProject(Project projectDetails) {
		
		return projectDetailsRepository.addNewProject(projectDetails);
	}

	@Override
	public Project UpdateProject(Project projectDetails) {
		
		return projectDetailsRepository.UpdateProject(projectDetails);
	}

	@Override
	public boolean deleteProject(String projectId) {
		
		return projectDetailsRepository.deleteProject(projectId);
	}

	@Override
	public Project getprojectByprojectId(String projectId) {
	
		return projectDetailsRepository.getprojectByprojectId(projectId);
	}

	@Override
	public List<Project> getAllproject() {
		
		return projectDetailsRepository.getAllproject();
	}

}
