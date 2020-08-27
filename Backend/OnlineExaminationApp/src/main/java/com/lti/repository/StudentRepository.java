package com.lti.repository;

import com.lti.entity.Login_Details;
import com.lti.entity.Student_Info;

public interface StudentRepository {

	public void RegisterUser(Student_Info studentinfo);
	void save(Object obj);
	boolean isUserPresent(String email);
	int findByEmailAndPassword(String email, String password);
	Student_Info findById(int id);
	public void savelogin(Login_Details ls);
	
}
