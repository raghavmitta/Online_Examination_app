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

import com.lti.controller.AdminController;
import com.lti.dao.ExamQuestionsImplement;
import com.lti.dao.ExamSetupImplement;
import com.lti.dto.QuestionDto;
import com.lti.dto.ResponseDto;
import com.lti.dto.optionsDto;
import com.lti.dto.AdminViewQuestionDto;
import com.lti.entity.Detail_report_db;
import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;
import com.lti.entity.Student_Info;
import com.lti.services.ExamEngineServices;
import com.lti.services.AdminService;


@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class OnlineExaminationAppApplicationTests {
	/*@Autowired
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
		
	}*/
	@Autowired
	private AdminController admin; 
	
	
	@Test
	public void addNewExam() {
		Exam_Db e = new Exam_Db();
		e.setExam_name("bigdata");
		e.setDuration_level1(120);
		e.setDuration_level2(120);
		e.setDuration_level3(120);
		e.setPassing_score_level1(100);
		e.setPassing_score_level2(100);
		e.setPassing_score_level3(100);
		
		admin.addSubject(e);
	}
	
//	@Test
//	public void Servicestest() {
//		List<QuestionDto> questions=services.getquestions(43);
//		for(QuestionDto q :questions)
//		{
//			System.out.println(q.getQuestion());
//			for(optionsDto opt:q.getOptions())
//			{
//				System.out.println(opt.getOption());
//			}
//		}}
//	
//		@Test
//	public void Servicetest2() {
//			ResponseDto r=new ResponseDto();
//			r.setReponse("Use of pointers");
//			r.setResponse_id(45);
//			services.saveResponse(r);
//		}
		
	

	
	@Test
	public void addNewQuestion() {
		
		Question_bank question = new Question_bank();
		Exam_Db exam = admin.fetchSubjetById(2);
		
		question.setExam_id(exam);
		question.setQuestion("What is JRE?");
		question.setOption1("Java Runtime Environment");
		question.setOption2("Java Runnable Environment");
		question.setOption3("Java Runtime Entity");
		question.setOption4("Java Runnable Entity");
		question.setCorrect_answer("Java Runtime Environment");
		question.setQuestion_level(1);
		question.setMarks(4);
		question.setGroup_name(".java");
		
		admin.addQuestion(question);		
	}
	
	@Test
	public void fetchExam() {
		Exam_Db e = admin.fetchSubjetById(2);
		System.out.println(e.getExam_id() + " " + e.getExam_name()+ " " + e.getDuration_level1()+ " " + e.getDuration_level2()+ " " + e.getDuration_level3()+ " " + e.getPassing_score_level1()+ " " + e.getPassing_score_level2()+ " " + e.getPassing_score_level3());
	}
	
	@Test
	public void getAllSubject() {
		List <Exam_Db> list = admin.fetchAllSubject();
		for (Exam_Db obj : list) 
		{ 
		   System.out.println(obj.getExam_id() + " " + obj.getExam_name());
		}
	}
	@Test void getQuestionByExamId() {
		List<AdminViewQuestionDto> list = admin.fetchQuestionByExamId(2);
		for (AdminViewQuestionDto obj : list) 
		{ 
		   System.out.println(obj.getQuestion() + " " + obj.getQues_id() );
		}
}
	}
	
//	@Test void getQuestionByExamId() {
//		List<Question_bank> list = admin.fetchQuestionByExamId(2);
//		for (Question_bank obj : list) 
//		{ 
//		   System.out.println(obj.getQuestion() + " " + obj.getQues_id() );
//		}
//	}
//	@Test
//	public void getAllQuestion() {
//		List <Question_bank> list = admin.fetchAllQuestions();
//		for (Question_bank obj : list) 
//		{ 
//		   System.out.println(obj.getQuestion() + " " + obj.getQues_id() );
//		}
//	}
