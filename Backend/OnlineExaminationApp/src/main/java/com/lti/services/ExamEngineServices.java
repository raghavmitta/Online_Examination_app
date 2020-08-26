package com.lti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.dao.ExamSetup;
import com.lti.dao.ExamQuestions;
import com.lti.dto.ExamListDto;
import com.lti.dto.QuestionDto;
import com.lti.dto.ResponseDto;
import com.lti.dto.ResultDto;
import com.lti.dto.optionsDto;
import com.lti.entity.Detail_report_db;
import com.lti.entity.High_level_report;
import com.lti.entity.Subject_enrolled;
@Service
public class ExamEngineServices {

	@Autowired
	private ExamQuestions dao;
	@Autowired
	private ExamSetup setup;
	
	public int ExamSetup(int student_id,int exam_id) {
		
		Integer exam_level=setup.getlevel(student_id, exam_id); //Get eligible level for a student for a exam
		
		if(setup.checkreport(student_id, exam_id, exam_level)) 
		{
		High_level_report Hreport = setup.generateReportId(student_id,exam_id,exam_level); //Generate a high_level_report_id for that exam
		setup.preparetest(Hreport); //prepare a test for a exam_id and exam_level;
		return Hreport.getReport_id();
		}
		else {
			return setup.getreportid(student_id, exam_id, exam_level);
		}
	
	}
		

	
	
	
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
		dao.setresponse(r.getResponse_id(),r.getResponse());
	}
	public boolean isallowed(int stu_id,int exam_id) {
		int count=setup.istestlive(stu_id);
		System.out.println("count:"+count);
		if(count==exam_id ||count==0)
			return true;
		else
			return false;
		
	}
	public ResultDto SubmitExam(int student_id, int exam_id) {
		int exam_level=setup.getlevel(student_id, exam_id);
		int report_id=setup.getreportid(student_id, exam_id, exam_level);
		High_level_report report=dao.PrepareResult(report_id);
		return new ResultDto(report.getExam_level(),report.getScore(),report.getStatus()); 
	}
	public List<ExamListDto> getexamlist(int stu_id){
		List<Subject_enrolled> sList=setup.getexamlist(stu_id);
		List<ExamListDto> examlist=new ArrayList<ExamListDto>(sList.size());
		
		for(Subject_enrolled subject: sList)
		{
			int level=setup.getlevel(stu_id, subject.getExam_id().getExam_id());
		examlist.add(new ExamListDto(subject.getExam_id().getExam_name(),subject.getExam_id().getExam_id(),level));
		}
		return examlist;
	}

}
