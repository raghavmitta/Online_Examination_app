package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Detail_report_db;

@Repository
public class ExamQuestionsImplement {
	@PersistenceContext
	private EntityManager entitymanager;
public List<Detail_report_db> getQuestions(int report_id)
{
	List<Detail_report_db> questionlist=entitymanager.createQuery("select r from Detail_report_db r where r.report_id.report_id=:r_id")
			.setParameter("r_id", report_id).getResultList();
	return questionlist;
}
@Transactional
public void setresponse(int response_id,String response) {
	Detail_report_db d=entitymanager.find(Detail_report_db.class,response_id);
	d.setResponse(response);
	entitymanager.merge(d);
}


}
