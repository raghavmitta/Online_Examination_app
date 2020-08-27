package com.lti.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.controller.RegisterController.Status.StatusType;
import com.lti.entity.Student_Info;
import com.lti.exception.StudentServiceException;
import com.lti.repository.StudentRepository;
public class RegisterController {
	
	private StudentRepository studentrepo;

	@RequestMapping(path="/RegisterUser.api", method=RequestMethod.POST)
	public Status RegisterUser(@RequestBody Student_Info studentinfo) {
		try {		
		studentrepo.RegisterUser(studentinfo);
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Registration successfull!");
		return status;
	}
	catch(StudentServiceException e) {
		Status status = new Status();
		status.setStatus(StatusType.FAILURE);
		status.setMessage(e.getMessage());
		return status;
	}
}
	
	public static class LoginStatus extends Status{
		private int customerId;
		private String name;
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
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