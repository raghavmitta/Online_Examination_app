package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Detail_report_db {
	@Id
	@GeneratedValue
    private int response_id;
    @JoinColumn(referencedColumnName = "quesid")
    private Question_bank ques_id;
	@JoinColumn(referencedColumnName = "report_id")
    private High_level_report report_id ;
    private String response;
    public int getResponse_id() {
		return response_id;
	}
	public void setResponse_id(int response_id) {
		this.response_id = response_id;
	}
	public Question_bank getQues_id() {
		return ques_id;
	}
	public void setQues_id(Question_bank ques_id) {
		this.ques_id = ques_id;
	}
	public High_level_report getReport_id() {
		return report_id;
	}
	public void setReport_id(High_level_report report_id) {
		this.report_id = report_id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}


}
