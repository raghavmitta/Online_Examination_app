package com.lti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ExamQuestionsImplement;
import com.lti.dto.QuestionDto;
import com.lti.dto.ResponseDto;
import com.lti.dto.optionsDto;
import com.lti.entity.Detail_report_db;
@Service
public class ExamEngineServices {

	@Autowired
	private ExamQuestionsImplement dao;
	public List<QuestionDto> getquestions(int report_id)
	{
		List<Detail_report_db> questions=dao.getQuestions(report_id);
		List<QuestionDto> qdtolist=new ArrayList<QuestionDto>(); 
		for(Detail_report_db q:questions) {
			QuestionDto questiondto=new QuestionDto();
			List<optionsDto> options=new ArrayList<optionsDto>();
			questiondto.setQuestion(q.getQues_id().getQuestion());
			options.add(new optionsDto(q.getQues_id().getOption1()));
			options.add(new optionsDto(q.getQues_id().getOption2()));
			options.add(new optionsDto(q.getQues_id().getOption3()));
			options.add(new optionsDto(q.getQues_id().getOption4()));
			questiondto.setOptions(options);
			questiondto.setResponseid(q.getResponse_id());
			questiondto.setResponse(q.getResponse());
			qdtolist.add(questiondto);
		}
		return qdtolist;
	}
	public void saveResponse(ResponseDto r) {
		dao.setresponse(r.getResponse_id(),r.getReponse());
	}

}
