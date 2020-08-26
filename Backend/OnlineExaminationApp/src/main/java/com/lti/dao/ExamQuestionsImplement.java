package com.lti.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Detail_report_db;
import com.lti.entity.High_level_report;
import com.lti.entity.Subject_enrolled;

@Repository
public class ExamQuestionsImplement implements ExamQuestions {
	@PersistenceContext
	private EntityManager entitymanager;

public List<Detail_report_db> getQuestions(int report_id)
{
	List<Detail_report_db> questionlist=entitymanager.createQuery("select r from Detail_report_db r where r.report_id.report_id=:r_id")
			.setParameter("r_id", report_id).getResultList();
	return questionlist;
}

@Transactional
public void setresponse(int response_id,String response) {
	Detail_report_db d=entitymanager.find(Detail_report_db.class,response_id);
	d.setResponse(response);
	entitymanager.merge(d);
}
@Transactional
public High_level_report PrepareResult(int report_id){
	High_level_report report=entitymanager.find(High_level_report.class,report_id);
	report.setEnding_time(LocalDateTime.now());
	List<Detail_report_db> responselist=entitymanager.createQuery("select r from Detail_report_db r where r.report_id.report_id=:r_id")
			.setParameter("r_id",report_id).
			getResultList();
	int score=0;

	for(Detail_report_db r : responselist) {
		if(r.getQues_id().getCorrect_answer().equalsIgnoreCase(r.getResponse()));
		{
			score+=r.getQues_id().getMarks();
		}
	}
	report.setScore(score);
	int passingScore=0;
	int level=report.getExam_level();
	switch(level)
	{
	case 1:passingScore=report.getExam_id().getPassing_score_level1();
		break;
	case 2:passingScore=report.getExam_id().getPassing_score_level2();
		break;
	case 3:passingScore=report.getExam_id().getPassing_score_level3();
		break;
	}
	Subject_enrolled S=(Subject_enrolled)entitymanager.createQuery("select enroll from Subject_enrolled enroll where enroll.exam_id.exam_id=:e_id and enroll.stu_id.stu_id=:s_id")
			.setParameter("e_id", report.getExam_id().getExam_id())
			.setParameter("s_id",report.getStu_id().getStu_id())
			.getSingleResult();
	if(score>=passingScore) {
		report.setStatus("PASS");
		S.setPassing_level(report.getExam_level());
	}
	else
		report.setStatus("FAIL");
	return report;
}
	


}
