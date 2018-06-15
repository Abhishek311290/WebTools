package com.neu.FinalBean;
import javax.persistence.*;

@Entity
@Table(name = "Login")
public class Login implements java.io.Serializable  {
		@Id
	 	@Column(name = "userName",unique=true,nullable=false)
	 	private String userName;
	 	@Column(name = "password")
	    private String password;
	 	@Column(name = "email")
	    private String email;
	 	@Column(name = "role")
	    private String role;
	    
	    public Login(){
	    	
	    }

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
	    
	    

}
