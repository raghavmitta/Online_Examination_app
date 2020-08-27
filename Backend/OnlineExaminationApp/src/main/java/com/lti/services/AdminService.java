package com.lti.services;

import java.util.List;

import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;

public interface AdminService {

	void save(Object obj);

	List<Exam_Db> fetchAllSubjects();

	Exam_Db fetchExamById(int examId);

	Question_bank fetchQuestion(int id);

	List<Question_bank> fetchQuestionByExamId(int examId);

	void readFile(int exam_id, String fileName, String targetFile) throws Exception;

	List<Question_bank> fetchAllQuestions();

}