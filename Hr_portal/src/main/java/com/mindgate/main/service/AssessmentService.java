package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Assessment;
import com.mindgate.main.repository.AssessmentRepositoryInterface;


@Service
public class AssessmentService implements AssessmentServiceInterface {

	@Autowired
	private AssessmentRepositoryInterface assessmentRepositoryInterface;

	@Override
	public boolean addNewAssessment(Assessment assessment) {

		return assessmentRepositoryInterface.addNewAssessment(assessment);
	}

	@Override
	public Assessment updateAssessment(Assessment assessment) {

		return assessmentRepositoryInterface.updateAssessment(assessment);
	}

	@Override
	public boolean deleteAssessment(String assessmentId) {
		
		return assessmentRepositoryInterface.deleteAssessment(assessmentId);
	}

	@Override
	public Assessment getOneAssessmentID(String assessmentId) {
		
		return assessmentRepositoryInterface.getOneAssessmentID(assessmentId);
	}

	@Override
	public List<Assessment> getAllAssessment() {

		return assessmentRepositoryInterface.getAllAssessment();
	}

}
