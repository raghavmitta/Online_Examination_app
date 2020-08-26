package com.lti.dto;

public class ResultDto {
	private int examlevel;
	private int  score;
	private String status;
	public ResultDto() {
		
	}
	public ResultDto(int examlevel, int score, String status) {
		super();
		this.examlevel = examlevel;
		this.score = score;
		this.status = status;
	}
	public int getExamlevel() {
		return examlevel;
	}
	public void setExamlevel(int examlevel) {
		this.examlevel = examlevel;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
