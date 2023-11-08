package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Project;

public interface ProjectRepositoryInterface {
	
	public boolean addNewProject(Project projectDetails);
	
    public Project UpdateProject(Project projectDetails);
    
    public boolean deleteProject(String projectId);
    
    public Project getprojectByprojectId(String projectId);
    
    public List<Project> getAllproject();

}
