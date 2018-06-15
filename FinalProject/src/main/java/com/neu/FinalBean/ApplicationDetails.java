package com.neu.FinalBean;
import java.io.Serializable;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "ApplicationDetails")
public class ApplicationDetails implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "applicationID",unique=true,nullable=false)
	private int applicationID;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "organisation")
	private String organisation;
	
	@Column(name = "jobDesc")
	private String jobDesc;
	
	@Column(name = "skills")
	private String skills;
	
	@Column(name = "postedBy")
	private String postedBy;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "resumeFileName")
	private String resumeFileName;
	
	@Column(name = "resumeAnalyzerComment")
	private String resumeAnalyzerComment;
	
	@Transient
	private CommonsMultipartFile resumeFile;
	
	@Column(name = "status")
	private String status;
	
	

	public String getResumeAnalyzerComment() {
		return resumeAnalyzerComment;
	}

	public void setResumeAnalyzerComment(String resumeAnalyzerComment) {
		this.resumeAnalyzerComment = resumeAnalyzerComment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResumeFileName() {
		return resumeFileName;
	}

	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}
	
   
	public CommonsMultipartFile getResumeFile() {
		return resumeFile;
	}

	public void setResumeFile(CommonsMultipartFile resumeFile) {
		this.resumeFile = resumeFile;
	}

	

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
