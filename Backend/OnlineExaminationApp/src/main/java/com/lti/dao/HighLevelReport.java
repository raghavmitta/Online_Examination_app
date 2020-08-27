package com.lti.dao;

import java.util.List;

import com.lti.entity.High_level_report;

public interface HighLevelReport {

	List<High_level_report> getStudentById(int stu_id);

	void save(Object obj);

}