package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ExamListDto;
import com.lti.dto.QuestionDto;
import com.lti.dto.ResponseDto;
import com.lti.dto.ResultDto;
import com.lti.services.ExamEngineServices;
@RestController
@CrossOrigin
public class ExamEngineController {
	@Autowired
	private ExamEngineServices services;
	
	@RequestMapping(path = "/beginexam/{exam_id}/{stu_id}", method=RequestMethod.GET)
	public List<QuestionDto> beginexam(@PathVariable int exam_id,@PathVariable int stu_id)
	{
		if(services.isallowed(stu_id,exam_id))
		{
		int report_id=services.ExamSetup(stu_id, exam_id);
		System.out.println(report_id);
		return services.getquestions(report_id); //67
		}
		else
			return null;
	 
	}
	@RequestMapping(path="/saveresponse",method=RequestMethod.POST)
	public int saveresponse(@RequestBody ResponseDto r)
	{
		System.out.println(r.getResponse());
		services.saveResponse(r);
		return 0;
	}
	@RequestMapping(path="/getresult/{exam_id}/{stu_id}",method=RequestMethod.GET)
	public ResultDto getresult(@PathVariable int exam_id,@PathVariable int stu_id) {
		return services.SubmitExam(stu_id,exam_id);
	}
	@RequestMapping(path="/getexamlist/{stu_id}",method=RequestMethod.GET)
	public List<ExamListDto> getexamlist(@PathVariable int stu_id){
		return services.getexamlist(stu_id);
		
	}
	
	
}
