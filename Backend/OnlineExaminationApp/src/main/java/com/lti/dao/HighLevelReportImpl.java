package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.High_level_report;
import com.lti.entity.Student_Info;

@Repository
public class HighLevelReportImpl implements HighLevelReport {
	@PersistenceContext
	private EntityManager entityManager;
	@Transactional
	public void save (Object obj) {
		entityManager.merge(obj);
	}
	
	
        @Override
	    public List<High_level_report> getStudentById(int stu_id) {
        return entityManager
                .createQuery("select high_level_report from High_level_report high_level_report where high_level_report.stu_id.stu_id = :stu_id")
                .setParameter("stu_id", stu_id)
                .getResultList();
    }
}

