package com.lti.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.controller.LoginController.Status.StatusType;
import com.lti.entity.Login_Details;
import com.lti.entity.Student_Info;
import com.lti.services.StudentService;
import com.lti.exception.StudentServiceException;

public class LoginController {

	private StudentService studentservice;
	
	@RequestMapping(path="/Login.api", method=RequestMethod.POST)
	public int LoginUser(@RequestBody Login_Details logindetails) {
		try {
			Student_Info student= studentservice.login(logindetails.getEmail_id(), logindetails.getPassword());
			LoginStatus loginStatus=new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Succesful");
			loginStatus.setStudentId(student.getStu_id());
			loginStatus.setName(student.getName());
			
			String atype=logindetails.getAccesstype();
			if(atype=="admin")
				return -2;
			else
				return student.getStu_id();
			
		}
		catch(StudentServiceException e){
			LoginStatus loginStatus=new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return -1;
			
		}
	}
		public static class LoginStatus extends Status{
			private int studentId;
			private String name;
			
			public int getStudentId() {
				return studentId;
			}
			public void setStudentId(int studentId) {
				this.studentId = studentId;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			
		}
		
		public static class Status {
			private StatusType status;
			private String message;
			
			public static enum StatusType {
				SUCCESS, FAILURE;
			}

			public StatusType getStatus() {
				return status;
			}

			public void setStatus(StatusType status) {
				this.status = status;
			}

			public String getMessage() {
				return message;
			}

			public void setMessage(String message) {
				this.message = message;
			}
		}
}
