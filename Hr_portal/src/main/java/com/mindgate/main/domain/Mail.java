package com.mindgate.main.domain;




public class Mail {
	private String name;
	private String mailId;
	private String subject;
	private String body;
	private String interviewDate;
	
	public Mail() {
		// TODO Auto-generated constructor stub
	}

	public Mail(String name, String mailId, String subject, String body, String interviewDate) {
		super();
		this.name = name;
		this.mailId = mailId;
		this.subject = subject;
		this.body = body;
		this.interviewDate = interviewDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}

	@Override
	public String toString() {
		return "Mail [name=" + name + ", mailId=" + mailId + ", subject=" + subject + ", body=" + body
				+ ", interviewDate=" + interviewDate + "]";
	}

	 

	 
}
