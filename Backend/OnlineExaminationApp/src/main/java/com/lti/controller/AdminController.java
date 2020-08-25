package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;
import com.lti.services.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/addsubject")
	public void addSubject(Exam_Db exam) {
		adminService.save(exam);
	}
	
	@PostMapping(path = "/viewsubject")
	public Exam_Db fetchSubjetById(int examId) {
		return adminService.fetchExamById(examId);
	}
	
	@GetMapping("/subjectlist")
	public List<Exam_Db> fetchAllSubject(){
		return adminService.fetchAllSubjects();
	}
	
	@PostMapping(path = "/addquestion")
	public void addQuestion(Question_bank question) {
		adminService.save(question);
	}
	
	//@PostMapping(path = "/fetchquestion")
	@RequestMapping(path = "/fetchquestion" , method = RequestMethod.POST)
	public List<Question_bank> fetchQuestionByExamId (@RequestBody int examId) {
		//int eid = examId;
		return adminService.fetchQuestionByExamId(examId);
	}
	
	//public List<Question_bank> fetchAllQuestions(){
	//	return adminService.fetchAllQuestions();
	//}
	

}
