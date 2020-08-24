package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.lti.entity.Exam_Db;


public class GenericDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	//generic function to add or update record.
	@Transactional
	public void save (Object obj) {
		entityManager.merge(obj);
	}
	
	//generic function to fetch record via primarykey.
	//<T> is like a Placeholder
	public <T> T fetchById(Class<T> clazz, Object pk) {
		return entityManager.find(clazz, pk);
	}
	

}
