package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.HighLevelReport;
import com.lti.entity.High_level_report;

@Service
@Transactional
public class HighLevelReportServiceImpl implements HighLevelReportService {
	@Autowired
	private HighLevelReport highlevelreport;
	@Override
	  public void save(Object obj) {
	         highlevelreport.save(obj);
	    }
	
	@Override
	public List<High_level_report> getStudentById(int stu_id){
		return highlevelreport.getStudentById(stu_id);
	}
	
	

}
