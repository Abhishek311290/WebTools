package com.neu.FinalBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JobDetails")
public class JobDetails implements java.io.Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "jobID",unique=true,nullable=false)
private int jobID;
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

public JobDetails(){
	
}

public int getJobID() {
	return jobID;
}

public void setJobID(int jobID) {
	this.jobID = jobID;
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


}
