package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;
import com.lti.services.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	public void addSubject(Exam_Db exam) {
		adminService.save(exam);
	}
	public Exam_Db fetchSubjetById(int examId) {
		return adminService.fetchExamById(examId);
	}
	
	public List<Exam_Db> fetchAllSubject(){
		return adminService.fetchAllSubjects();
	}
	
	public void addQuestion(Question_bank question) {
		adminService.save(question);
	}
	
	public List<Question_bank> fetchQuestionByExamId (int examId) {
		return adminService.fetchQuestionByExamId(examId);
	}
	
	//public List<Question_bank> fetchAllQuestions(){
	//	return adminService.fetchAllQuestions();
	//}
	

}
