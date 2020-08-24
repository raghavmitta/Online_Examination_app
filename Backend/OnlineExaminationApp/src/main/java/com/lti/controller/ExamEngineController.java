package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.ExamQuestionsImplement;
import com.lti.dto.QuestionDto;
import com.lti.dto.ResponseDto;
import com.lti.services.ExamEngineServices;
@RestController
@CrossOrigin
public class ExamEngineController {
	@Autowired
	private ExamEngineServices services;
	
	@GetMapping("/beginexam/{exam_id}")
	public List<QuestionDto> beginexam(@PathVariable int exam_id)
	{
		int report_id=services.ExamSetup(1, exam_id);
		return services.getquestions(report_id);
	 
	}
	@PostMapping("/saveresponse")
	public void saveresponse(@RequestBody ResponseDto r)
	{
		System.out.println(r.getResponse());
		services.saveResponse(r);
	}
}
