package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class High_level_report {
	@Id
	@GeneratedValue
	private int report_id;
	@JoinColumn
	@ManyToOne
    private Student_Info stu_id;
	@JoinColumn
	@ManyToOne
    private Exam_Db exam_id;
    private int score;
    private int exam_level;
    private String status;
    private String report_link;
    private int cheating;
    private LocalDateTime starting_time; 
    private LocalDateTime ending_time;
    private LocalDate exam_date;
    
   
    public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public Student_Info getStu_id() {
		return stu_id;
	}
	public void setStu_id(Student_Info stu_id) {
		this.stu_id = stu_id;
	}
	public Exam_Db getExam_id() {
		return exam_id;
	}
	public void setExam_id(Exam_Db exam_id) {
		this.exam_id = exam_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getExam_level() {
		return exam_level;
	}
	public void setExam_level(int exam_level) {
		this.exam_level = exam_level;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReport_link() {
		return report_link;
	}
	public void setReport_link(String report_link) {
		this.report_link = report_link;
	}
	public int getCheating() {
		return cheating;
	}
	public void setCheating(int cheating) {
		this.cheating = cheating;
	}
	public LocalDateTime getStarting_time() {
		return starting_time;
	}
	public void setStarting_time(LocalDateTime starting_time) {
		this.starting_time = starting_time;
	}
	public LocalDateTime getEnding_time() {
		return ending_time;
	}
	public void setEnding_time(LocalDateTime ending_time) {
		this.ending_time = ending_time;
	}
	public LocalDate getExam_date() {
		return exam_date;
	}
	public void setExam_date(LocalDate exam_date) {
		this.exam_date = exam_date;
	}
	

}
