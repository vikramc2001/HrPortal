package com.mindgate.main.domain;

public class Assessment {

	private String assessmentId;
	private String round1;
	private String round2;
	private String round3;
	private String status;
	private String candidateId;
	private Candidate candidate;

	public Assessment() {

	}

	public Assessment(String assessmentId, String round1, String round2, String round3, String status,
			String candidateId, Candidate candidate) {
		super();
		this.assessmentId = assessmentId;
		this.round1 = round1;
		this.round2 = round2;
		this.round3 = round3;
		this.status = status;
		this.candidateId = candidateId;
		this.candidate = candidate;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getRound1() {
		return round1;
	}

	public void setRound1(String round1) {
		this.round1 = round1;
	}

	public String getRound2() {
		return round2;
	}

	public void setRound2(String round2) {
		this.round2 = round2;
	}

	public String getRound3() {
		return round3;
	}

	public void setRound3(String round3) {
		this.round3 = round3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Assessment [assessmentId=" + assessmentId + ", round1=" + round1 + ", round2=" + round2 + ", round3="
				+ round3 + ", status=" + status + ", candidateId=" + candidateId + ", candidate=" + candidate + "]";
	}

}
