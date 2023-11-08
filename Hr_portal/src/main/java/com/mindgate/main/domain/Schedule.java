package com.mindgate.main.domain;

import java.util.Date;

public class Schedule {

	private String scheduleId;
	private String candidateId;
	private Candidate candidate;
	private String interviewerId;
	private Date interviewDate;
	private String interviewStatus;
	private String assessmentId;
	private Assessment assessment;

	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Schedule(String scheduleId, String candidateId, Candidate candidate, String interviewerId,
			Date interviewDate, String interviewStatus, String assessmentId, Assessment assessment) {
		super();
		this.scheduleId = scheduleId;
		this.candidateId = candidateId;
		this.candidate = candidate;
		this.interviewerId = interviewerId;
		this.interviewDate = interviewDate;
		this.interviewStatus = interviewStatus;
		this.assessmentId = assessmentId;
		this.assessment = assessment;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(String interviewerId) {
		this.interviewerId = interviewerId;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", candidateId=" + candidateId + ", candidate=" + candidate
				+ ", interviewerId=" + interviewerId + ", interviewDate=" + interviewDate + ", interviewStatus="
				+ interviewStatus + ", assessmentId=" + assessmentId + ", assessment=" + assessment + "]";
	}

}
