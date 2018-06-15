package com.neu.FinalBean;
import javax.persistence.*;

@Entity
@Table(name = "UserProfileDetails")
public class UserProfileDetails {
	@Id
 	@Column(name = "userName",unique=true,nullable=false)
 	private String userName;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "skills")
	private String skills;
	
	@Column(name = "major")
	private String major;
	
	@Column(name = "email")
	private String email;

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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
