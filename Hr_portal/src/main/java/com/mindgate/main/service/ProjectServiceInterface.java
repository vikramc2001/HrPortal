package com.mindgate.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Project;

@Service
public interface ProjectServiceInterface {
	public boolean addNewProject(Project projectDetails);
    public Project UpdateProject(Project projectDetails);
    public boolean deleteProject(String projectId);
    public Project getprojectByprojectId(String projectId);
    public List<Project> getAllproject();

}
