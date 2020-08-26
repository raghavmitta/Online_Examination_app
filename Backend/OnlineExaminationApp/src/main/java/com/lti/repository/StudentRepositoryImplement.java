package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Student_Info;

public class StudentRepositoryImplement implements StudentRepository{

	@PersistenceContext //@Autowired does not work for injecting EntityManager
    private EntityManager entityManager;
	
	@Transactional
	public void RegisterUser(Student_Info studentinfo) {
		entityManager.persist(studentinfo);
		
	}

	@Transactional
	public void save(Student_Info studentinfo) {
		entityManager.merge(studentinfo);
    }

	@Override
	public Student_Info findById(int id) {
		return entityManager.find(Student_Info.class, id);
	}
	
	@Override
	public boolean isUserPresent(String email){
		return (Long) entityManager
				.createQuery("select count(s.id) from Student_Info s where s.email = :em")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}
	@Override
	public int findByEmailAndPassword(String email,String password) {
		return (Integer) entityManager
				.createQuery("select s.id from Student_Info s where s.email=:em and s.password= :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
}
