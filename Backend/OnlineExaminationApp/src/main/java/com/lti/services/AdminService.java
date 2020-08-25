package com.lti.services;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public void save(Object obj) {
		 adminDao.save(obj);
	}
	
	public List<Exam_Db> fetchAllSubjects(){
		return adminDao.fetchAllSubjects();
	}
	
	public Exam_Db fetchExamById(int examId) {
		return (adminDao.fetchById(Exam_Db.class, examId));
	}
	
	public List <Question_bank> fetchQuestionByExamId(int examId){
		return adminDao.fetchQuestionByExamId(examId);
	}

	public void readFile(int exam_id, String fileName, String targetFile) throws Exception {
		List <Question_bank> questionList = new ArrayList();
			String file = targetFile;
			System.out.println("readingcsv lin by line");
			try (Stream<String> stream = Files.lines(Paths.get(file)).skip(1)) {
				stream.forEach(line -> {
					String[] split = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
					//https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
					Question_bank question = new Question_bank();
					
					question.setQuestion(split[0]);
					question.setOption1(split[1]);
					question.setOption2(split[2]);
					question.setOption3(split[3]);
					question.setOption4(split[4]);
					question.setCorrect_answer(split[5]);
					question.setQuestion_level(Integer.parseInt(split[6]));
					question.setMarks(Integer.parseInt(split[7]));
					question.setGroup_name(fileName);
					
					questionList.add(question);
				});
			}
			catch(IOException e) {
				throw new Exception("Error while reading complaints.csv file", e);
			}
			System.out.println("arraylist made");
			Exam_Db exam = (adminDao.fetchById(Exam_Db.class, exam_id));
			
			for (Question_bank obj : questionList) {
				Question_bank question = new Question_bank();
				question.setExam_id(exam);	
				adminDao.save(obj);
			}
		}
		
	
	//public List<Question_bank> fetchAllQuestions(){
		//return adminDao.fetchAllQuestions();
	//}
	
	
}