package com.mindgate.main.domain;

import java.util.Date;

public class Employee {
	
	private String employeeId;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private long phoneNo;
	private String email;
	private Date dateOfBirth;
	private String designation;
	private String skill1;
	private String skill2;
	private String skill3;
	private double salary;
	private String projectId;
	private Project projectDetails;
	private String managerId;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeId, String password, String firstName, String lastName, String gender, long phoneNo,
			String email, Date dateOfBirth, String designation, String skill1, String skill2, String skill3,
			double salary, String projectId, Project projectDetails, String managerId) {
		super();
		this.employeeId = employeeId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.designation = designation;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.salary = salary;
		this.projectId = projectId;
		this.projectDetails = projectDetails;
		this.managerId = managerId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Project getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(Project projectDetails) {
		this.projectDetails = projectDetails;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", designation=" + designation + ", skill1=" + skill1 + ", skill2="
				+ skill2 + ", skill3=" + skill3 + ", salary=" + salary + ", projectId=" + projectId
				+ ", projectDetails=" + projectDetails + ", managerId=" + managerId + "]";
	}
	
	
}