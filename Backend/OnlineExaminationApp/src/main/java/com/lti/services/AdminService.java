package com.lti.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public void save(Object obj) {
		 adminDao.save(obj);
	}
	
	public List<Exam_Db> fetchAllSubjects(){
		return adminDao.fetchAllSubjects();
	}
	
	public Exam_Db fetchExamById(int examId) {
		return (adminDao.fetchById(Exam_Db.class, examId));
	}
	
	public List <Question_bank> fetchQuestionByExamId(int examId){
		return adminDao.fetchQuestionByExamId(examId);
	}
	
	//public List<Question_bank> fetchAllQuestions(){
		//return adminDao.fetchAllQuestions();
	//}
	
	
}