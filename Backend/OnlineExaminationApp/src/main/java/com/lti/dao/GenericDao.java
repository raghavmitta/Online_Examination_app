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
	public <T> T fetchById(Class<T> clazz, Object pk) {
		return entityManager.find(clazz, pk);
	}
	
	//generic function to fetch all record of a table.
	public List<Object> findAll() {
		return entityManager
				.createNamedQuery("fetch-all")
				.getResultList();
	}
}
