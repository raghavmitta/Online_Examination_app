package com.lti.dto;

public class ExamListDto {
	
private String examName;
private int exam_id;
private int level;
public ExamListDto() {}
public ExamListDto(String examName, int exam_id, int level) {
	super();
	this.examName = examName;
	this.exam_id = exam_id;
	this.level = level;
}
public int getExam_id() {
	return exam_id;
}
public void setExam_id(int exam_id) {
	this.exam_id = exam_id;
}

public String getExamName() {
	return examName;
}
public void setExamName(String examName) {
	this.examName = examName;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}

}
