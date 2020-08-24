package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Detail_report_db;
import com.lti.entity.Exam_Db;
import com.lti.entity.High_level_report;
import com.lti.entity.Question_bank;
import com.lti.entity.Student_Info;

@Repository
public class ExamSetupImplement {
	@PersistenceContext
	private EntityManager entitymanager;
	@Transactional
	public void insert(Question_bank question)
	{
		entitymanager.merge(question);
	}
	/*
	public String SetupExam(int student_id,int exam_id)
	{
		Integer exam_level=getlevel(student_id, exam_id);
		if(checkreport(student_id,exam_id,(int)exam_level))
		{
			High_level_report Hreport = generateReportId(student_id,exam_id,exam_level);
			preparetest(Hreport);
		}
		else
		System.out.println("hello");
	return "hello";
	}*/
	
	
	public boolean checkreport(int student_id,int exam_id,int exam_level) {
		return (long)entitymanager.createQuery("Select count(report) from High_level_report report where report.exam_level=:level and report.stu_id.stu_id=:s_id and report.exam_id.exam_id=:e_id")
				.setParameter("level",exam_level )
				.setParameter("e_id", exam_id)
				.setParameter("s_id", student_id).getSingleResult()>0 ?false:true ;

	}
	
	public int getlevel(int student_id,int exam_id)
	{
	Integer exam_level=(Integer)entitymanager.createQuery("select enroll.Passing_level from Subject_enrolled enroll where enroll.exam_id.exam_id=:e_id and enroll.stu_id.stu_id=:s_id").
				setParameter("e_id", exam_id).setParameter("s_id",student_id).getSingleResult();
		return exam_level+1;
	}
	
	@Transactional
	public High_level_report generateReportId(int student_id,int exam_id,int exam_level)
	{
		High_level_report highL_report=new High_level_report();
		Student_Info student=entitymanager.find(Student_Info.class, student_id);
		Exam_Db exam=entitymanager.find(Exam_Db.class, exam_id);
		highL_report.setExam_id(exam);
		highL_report.setStu_id(student);
		highL_report.setExam_level(exam_level);
		entitymanager.persist(highL_report);
		return highL_report;
	}
	
	@Transactional
	public void preparetest(High_level_report Hreport)
	{
		int exam_id=Hreport.getExam_id().getExam_id();
		List<Question_bank> questions=entitymanager.createQuery("select q from Question_bank q where q.exam_id.exam_id=:id").
				setParameter("id",exam_id).
				getResultList();
		for(Question_bank q : questions) {
			Detail_report_db report=new Detail_report_db();
			report.setQues_id(q);
			report.setReport_id(Hreport);
			entitymanager.merge(report);
		
		}

	}
	public int getreportid() {
		return 0;
	}

}
