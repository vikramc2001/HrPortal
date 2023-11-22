package com.mindgate.main.domain;

import java.util.Arrays;
import java.util.Date;

public class Candidate {

	private String candidateId;
	private String candidateName;
	private String skill1;
	private String skill2;
	private String skill3;
	private String title;
	private String qualification;
	private String passedOutYear;
	private String experience;
	private String grade;
	private Long phone;
	private String email;
	private Date applyDate;
	private String jobId;
	private String status;
	private byte[] resume;
	private Job job;

	public Candidate() {
		// TODO Auto-generated constructor stub
	}

	public Candidate(String candidateId, String candidateName, String skill1, String skill2, String skill3,
			String title, String qualification, String passedOutYear, String experience, String grade, Long phone,
			String email, Date applyDate, String jobId, String status, byte[] resume, Job job) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.title = title;
		this.qualification = qualification;
		this.passedOutYear = passedOutYear;
		this.experience = experience;
		this.grade = grade;
		this.phone = phone;
		this.email = email;
		this.applyDate = applyDate;
		this.jobId = jobId;
		this.status = status;
		this.resume = resume;
		this.job = job;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getSkill1() {
		return skill1;
	}

	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}

	public String getSkill2() {
		return skill2;
	}

	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}

	public String getSkill3() {
		return skill3;
	}

	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPassedOutYear() {
		return passedOutYear;
	}

	public void setPassedOutYear(String passedOutYear) {
		this.passedOutYear = passedOutYear;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", skill1=" + skill1
				+ ", skill2=" + skill2 + ", skill3=" + skill3 + ", title=" + title + ", qualification=" + qualification
				+ ", passedOutYear=" + passedOutYear + ", experience=" + experience + ", grade=" + grade + ", phone="
				+ phone + ", email=" + email + ", applyDate=" + applyDate + ", jobId=" + jobId + ", status=" + status
				+ ", resume=" + Arrays.toString(resume) + ", job=" + job + "]";
	}

	

	
		}