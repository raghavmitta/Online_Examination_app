package com.lti.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.lti.entity.High_level_report;
import com.lti.entity.Question_bank;
import com.lti.entity.Subject_enrolled;

public interface ExamSetup {

	void insert(Question_bank question);

	String SetupExam(int student_id, int exam_id);

	boolean checkreport(int student_id, int exam_id, int exam_level);

	int getlevel(int student_id, int exam_id);

	High_level_report generateReportId(int student_id, int exam_id, int exam_level);

	void preparetest(High_level_report Hreport);

	int getreportid(int student_id, int exam_id, int exam_level);

	int istestlive(int student_id);

	List<Subject_enrolled> getexamlist(int stu_id);

}