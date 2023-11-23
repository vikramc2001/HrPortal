package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.domain.Assessment;

public interface AssessmentServiceInterface  {
	
	
    public boolean addNewAssessment(Assessment  assessment);
    
    public Assessment updateAssessment(Assessment assessment);
    
    public boolean deleteAssessment(String assessmentId);
    
    public Assessment getOneAssessmentID(String assessmentId);
    
    public List<Assessment> getAllAssessment();

    
}
