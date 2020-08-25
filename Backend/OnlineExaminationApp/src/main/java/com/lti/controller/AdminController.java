package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminViewQuestionDto;
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
	
	@RequestMapping(path = "/fetchquestion/{examId}" , method = RequestMethod.GET)
	public List<AdminViewQuestionDto> fetchQuestionByExamId (@PathVariable int examId) {
		List <AdminViewQuestionDto> list = new ArrayList();
		
		for (Question_bank obj : adminService.fetchQuestionByExamId(examId)) 
		{ 
			AdminViewQuestionDto adminViewQuestionDto = new AdminViewQuestionDto();
		    BeanUtils.copyProperties(obj, adminViewQuestionDto);
		    list.add(adminViewQuestionDto);
		}
		return list;
	}
	
//	public List<Question_bank> fetchQuestionByExamId ( int examId) {
//	return adminService.fetchQuestionByExamId(examId);
//
//}
	//public List<Question_bank> fetchAllQuestions(){
	//	return adminService.fetchAllQuestions();
	//}
	

}
