package com.lti;


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
import com.lti.entity.Detail_report_db;
import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;
import com.lti.entity.Student_Info;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

class OnlineExaminationAppApplicationTests {
	@Autowired
	private ExamSetupImplement e;
	@Autowired
	private ExamQuestionsImplement q;
	@Test
	public void schematest() {
		Question_bank q=new Question_bank();
		q.setQuestion("Which of the following is not a Java features?");
		q.setOption1("Dynamic");
		q.setOption2("Architecture Neutral");
		q.setOption3("Use of pointers");
		q.setOption4("Object-oriented");
		q.setCorrect_answer(q.getOption3());
		q.setExam_id(e.fetchexamdb(101));
		q.setMarks(2);
		e.insert(q);
	}	
	@Test
	public void examsetuptest() {
		e.SetupExam(1, 101);
	
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
}
