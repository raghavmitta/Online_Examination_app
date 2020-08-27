package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.LoginController.Status.StatusType;
import com.lti.entity.Login_Details;
import com.lti.entity.Student_Info;
import com.lti.exception.StudentServiceException;
import com.lti.services.StudentService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private StudentService studentservice;
	
	@RequestMapping(path="/Login.api", method=RequestMethod.POST)
	public LoginStatus LoginUser(@RequestBody Login_Details logindetails){
		try {
			//System.out.println(logindetails.getEmail_id()+ logindetails.getPassword());
			Student_Info student= studentservice.login(logindetails.getEmail_id(), logindetails.getPassword());
			LoginStatus loginStatus=new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Succesful");
			loginStatus.setStudentId(student.getStu_id());
			loginStatus.setName(student.getName());
			
			String atype=logindetails.getAccesstype();
			if(atype=="admin")
			{
				loginStatus.setStatusCode(-2);
			}
			else
				loginStatus.setStatusCode(student.getStu_id());
			
			return loginStatus;
			
		}
		catch(Exception e){
			LoginStatus loginStatus=new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			loginStatus.setStatusCode(-1);
			
			return loginStatus;
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
			private int statusCode;
			
			
			public int getStatusCode() {
				return statusCode;
			}

			public void setStatusCode(int statusCode) {
				this.statusCode = statusCode;
			}

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
