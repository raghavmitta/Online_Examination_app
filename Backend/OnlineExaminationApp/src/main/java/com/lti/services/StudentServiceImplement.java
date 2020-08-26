package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Login_Details;
import com.lti.entity.Student_Info;
import com.lti.exception.StudentServiceException;
import com.lti.repository.StudentRepository;

public class StudentServiceImplement implements StudentService{

	@Autowired
	private StudentRepository studentrepo;
	
	
	@Transactional
	public Student_Info login(String email, String password) {
		return null;
	}

	@Override
	public void RegisterUser(Student_Info studentinfo) {
		if(!studentrepo.isUserPresent(studentinfo.getEmail_id().getEmail_id())) {
			studentrepo.save(studentinfo);
		}
		else
			throw new StudentServiceException("Customer Already Registred");
	}
}
