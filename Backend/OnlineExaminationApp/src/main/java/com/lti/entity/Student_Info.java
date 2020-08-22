package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student_Info {
	@Id
	@GeneratedValue
	 private int stu_id;

	 private String name;
	 @JoinColumn
	 @OneToOne
	 private Login_Details email_id;
	 private int mobile_no;
	 private String city;
	 private String state;
	 private LocalDate  dob;
	 private  String qualification;
	 private  int year_of_graduation;
	 
	 
	 public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getYear_of_graduation() {
		return year_of_graduation;
	}
	public void setYear_of_graduation(int year_of_graduation) {
		this.year_of_graduation = year_of_graduation;
	}
	
	   

}
