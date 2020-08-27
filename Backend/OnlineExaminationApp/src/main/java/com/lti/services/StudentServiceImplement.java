package com.lti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Student_Info;
import com.lti.exception.StudentServiceException;
import com.lti.repository.StudentRepository;

@Service
public class StudentServiceImplement implements StudentService{

	@Autowired
	private StudentRepository studentrepo;
	
	
	@Transactional
	public Student_Info login(String email, String password) throws Exception{
		try {
			int id = studentrepo.findByEmailAndPassword(email, password);
			Student_Info studentinfo= studentrepo.findById(id);
			return studentinfo;	
		}
		catch(Exception e) {
			System.out.println("In catch");
			throw new StudentServiceException("Incorrect username/password");
			
		}
	}

	public void save(Object obj) {
		studentrepo.save(obj);
	}
	
	public void RegisterUser(Student_Info studentinfo) {
		
		//if(!studentrepo.isUserPresent(studentinfo.getEmail_id().getEmail_id())) {
		try {
			studentrepo.save(studentinfo);
		//}
		//else
		}
		catch(Exception e) {
			throw new StudentServiceException("Customer Already Registred");
		}
	}
}
