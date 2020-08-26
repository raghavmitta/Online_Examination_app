package com.lti.services;

import com.lti.entity.Student_Info;

public interface StudentService {

	void RegisterUser(Student_Info studentinfo);
	Student_Info login(String email, String password);

}