package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


public class GenericDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	//generic function to add or update record.
	@Transactional
	public void save (Object obj) {
		entityManager.merge(obj);
	}
	
	//generic function to fetch record via primarykey.
	public <T> T fetchById(Class<T> clazz, int pk) {
		System.out.println("in generic dao");
		return entityManager.find(clazz, pk);
	}
	
}
