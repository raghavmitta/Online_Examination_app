package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login_Details {
	@Id
	private String email_id;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccesstype() {
		return accesstype;
	}
	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}
	private String password;
	private String accesstype;

}
