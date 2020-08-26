package com.lti.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.lti.entity.Detail_report_db;
import com.lti.entity.High_level_report;

public interface ExamQuestions {

	List<Detail_report_db> getQuestions(int report_id);

	void setresponse(int response_id, String response);

	High_level_report PrepareResult(int report_id);

}