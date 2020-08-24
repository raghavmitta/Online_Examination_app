package com.lti;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.dao.ExamQuestionsImplement;
import com.lti.dao.ExamSetupImplement;
import com.lti.dto.QuestionDto;
import com.lti.dto.ResponseDto;
import com.lti.dto.optionsDto;
import com.lti.entity.Detail_report_db;
import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;
import com.lti.entity.Student_Info;
import com.lti.services.ExamEngineServices;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

class OnlineExaminationAppApplicationTests {
	@Autowired
	private ExamSetupImplement e;
	@Autowired
	private ExamQuestionsImplement q;
	@Autowired 
	private ExamEngineServices services;
	@Test
	public void schematest() {
		Question_bank q=new Question_bank();
		q.setQuestion("Which of the following is not a Java features?");
		q.setOption1("Dynamic");
		q.setOption2("Architecture Neutral");
		q.setOption3("Use of pointers");
		q.setOption4("Object-oriented");
		q.setCorrect_answer(q.getOption3());
		
		q.setMarks(2);
		e.insert(q);
	}	
	
	
	@Test
	public void getquestionstest() {
		List<Detail_report_db> questions=q.getQuestions(43);
		for(Detail_report_db ques:questions)
		{
			System.out.println(ques.getResponse_id());
			System.out.println(ques.getQues_id().getQuestion());
		}
		
	}
	@Test
	public void Servicestest() {
		List<QuestionDto> questions=services.getquestions(43);
		for(QuestionDto q :questions)
		{
			System.out.println(q.getQuestion());
			for(optionsDto opt:q.getOptions())
			{
				System.out.println(opt.getOption());
			}
		}}
		@Test
	public void Servicetest2() {
			ResponseDto r=new ResponseDto();
			r.setReponse("Use of pointers");
			r.setResponse_id(45);
			services.saveResponse(r);
		}
		
	}

