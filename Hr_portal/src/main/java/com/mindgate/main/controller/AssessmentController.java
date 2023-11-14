package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Assessment;
import com.mindgate.main.service.AssessmentServiceInterface;

@RestController
@CrossOrigin("*")
@RequestMapping("assessmentapi")
public class AssessmentController {

	@Autowired
	private AssessmentServiceInterface assessmentServiceInterface;
    
// http://localhost:8081/assessmentapi/addassessment
	@RequestMapping(value = "addassessment", method = RequestMethod.POST)
	public boolean addNewAssessment(@RequestBody Assessment assessment) {

		return assessmentServiceInterface.addNewAssessment(assessment);
	}
 //   http://localhost:8081/assessmentapi/updateassessment
	@RequestMapping(value = "updateassessment", method = RequestMethod.PUT)
	public Assessment updateNewAssessment(@RequestBody Assessment assessment) {

		return assessmentServiceInterface.updateAssessment(assessment);
	}
//  http://localhost:8081/assessmentapi/delete/AST5002
	@RequestMapping(value = "delete/{assessmentId}", method = RequestMethod.DELETE)
	public boolean deleteAssessment(@PathVariable String assessmentId) {

		return assessmentServiceInterface.deleteAssessment(assessmentId);

	}
 //   http://localhost:8081/assessmentapi/getone/AST5003
	@RequestMapping(value = "getone/{assessmentId}", method = RequestMethod.GET)
	public Assessment getOneAssessmentID( @PathVariable String assessmentId) {

		return assessmentServiceInterface.getOneAssessmentID(assessmentId);

	}
//    http://localhost:8081/assessmentapi/getallassessment
	@RequestMapping(value = "getallassessment", method = RequestMethod.GET)
	public List<Assessment> getAllAssessment() {

		return assessmentServiceInterface.getAllAssessment();

	}
}
