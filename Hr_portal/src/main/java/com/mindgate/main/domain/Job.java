package com.mindgate.main.domain;

public class Job {

	private String jobId;
	private String title;
	private String qualification;
	private String skill1;
	private String skill2;
	private String skill3;
	private String projectId;
	private int requiredEmployees;
	private String status;
	private Project project;

	public Job() {
	}

	public Job(String jobId, String title, String qualification, String skill1, String skill2, String skill3,
			String projectId, int requiredEmployees, String status, Project project) {
		super();
		this.jobId = jobId;
		this.title = title;
		this.qualification = qualification;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.projectId = projectId;
		this.requiredEmployees = requiredEmployees;
		this.status = status;
		this.project = project;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public int getRequiredEmployees() {
		return requiredEmployees;
	}

	public void setRequiredEmployees(int requiredEmployees) {
		this.requiredEmployees = requiredEmployees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", title=" + title + ", qualification=" + qualification + ", skill1=" + skill1
				+ ", skill2=" + skill2 + ", skill3=" + skill3 + ", projectId=" + projectId + ", requiredEmployees="
				+ requiredEmployees + ", status=" + status + ", project=" + project + "]";
	}

		
}
