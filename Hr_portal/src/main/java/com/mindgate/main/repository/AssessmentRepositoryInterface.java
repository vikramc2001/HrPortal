package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Assessment;

public interface AssessmentRepositoryInterface {

	public boolean addNewAssessment(Assessment assessment);

	public Assessment updateAssessment(Assessment assessment);

	public boolean deleteAssessment(String assessmentId);

	public Assessment getOneAssessmentID(String assessmentId);

	public List<Assessment> getAllAssessment();

}
