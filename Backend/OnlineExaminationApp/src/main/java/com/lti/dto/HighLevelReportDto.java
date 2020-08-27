package com.lti.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.lti.entity.Exam_Db;

public class HighLevelReportDto {
	private String name;
	private int exam_id;
	private int score;
	private int exam_level;
    private LocalDateTime starting_time; 
    private LocalDateTime ending_time;
	private LocalDate exam_date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
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
