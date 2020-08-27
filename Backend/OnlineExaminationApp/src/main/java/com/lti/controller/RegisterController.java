package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.RegisterController.Status.StatusType;
import com.lti.entity.Student_Info;
import com.lti.exception.StudentServiceException;
import com.lti.repository.StudentRepository;
import com.lti.services.StudentService;


@RestController
@CrossOrigin
public class RegisterController {
	
	@Autowired
	private StudentRepository studentrepo;
	
	@Autowired
	private StudentService ss;

	@RequestMapping(path="/RegisterUser.api", method=RequestMethod.POST) 
	public Status RegisterUser(@RequestBody Student_Info studentinfo) {
		try {		
		
			studentrepo.save(studentinfo.getLogin());
		ss.RegisterUser(studentinfo);
		Status status = new Status();
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Registration successfull!");
		return status;
	} 
	catch(Exception e) {
		Status status = new Status();
		status.setStatus(StatusType.FAILURE);
		status.setMessage("Registration failed");
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