package com.lti.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.lti.repository.StudentRepository;
import com.lti.entity.Student_Info;
public class RegisterController {
	
	private StudentRepository studentrepo;

	@RequestMapping(path="/RegisterUser.api", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Status RegisterUser(@RequestBody Student_Info studentinfo) {
		studentrepo.RegisterUser(studentinfo);
		Status status = new Status();
		status.setMessage("Record added successfully");
		return status;
	}
	
	@RequestMapping(path="/Login.api", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Status LoginUser(@RequestBody Student_Info studentinfo) {
	
		Status status=new Status();
		
		return status;
	}
	public static class Status{
		
	
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}