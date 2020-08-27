package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.HighLevelReportDto;
import com.lti.entity.High_level_report;
import com.lti.entity.Student_Info;
import com.lti.services.HighLevelReportService;

@RestController
@CrossOrigin 
public class HighLevelReportController {
	
	@Autowired
	
	private HighLevelReportService highlevelreportservice;
	   @GetMapping(path = "/highlevelreport")
	    public void addHighLevelReport(High_level_report obj) {
	        highlevelreportservice.save(obj);
	    }

	@RequestMapping(path = "/highlevelreport/{stu_id}", method = RequestMethod.GET)
	public List<HighLevelReportDto> fetchhighlevelreportByID(@PathVariable int stu_id) {
		List <HighLevelReportDto> list = new ArrayList();
		highlevelreportservice.getStudentById(stu_id);
       for (High_level_report obj : highlevelreportservice.getStudentById(stu_id)) {
    	   HighLevelReportDto Dto = new HighLevelReportDto();
    	   Dto.setName(obj.getStu_id().getName());
    	   Dto.setExam_id(obj.getExam_id().getExam_id());
           BeanUtils.copyProperties(obj, Dto);
           list.add(Dto);
       }
       return list;
    }
} 
