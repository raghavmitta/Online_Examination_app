package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Admin_info {
	@Id
	@GeneratedValue
	private int admin_id;
	@Column(nullable = false)
    private String name; //varchar2(50) NOT NULL,
	@JoinColumn
    @OneToOne
    private Login_Details email_id; //varchar2(100) NOT NULL UNIQUE,
    private int mobile_no; //NUMBER(10) NOT NULL,
    public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Login_Details getEmail_id() {
		return email_id;
	}
	public void setEmail_id(Login_Details email_id) {
		this.email_id = email_id;
	}
	public int getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(int mobile_no) {
		this.mobile_no = mobile_no;
	}
	


}
