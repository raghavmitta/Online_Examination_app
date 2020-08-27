package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Exam_Db;
import com.lti.entity.Question_bank;
@Repository
public class AdminDao extends GenericDao {

	@PersistenceContext
	EntityManager entityManager;

	public List<Exam_Db> fetchAllSubjects() {
		return entityManager
				.createNamedQuery("fetch-all")
				.getResultList();
	}

	public List<Question_bank> fetchQuestionByExamId(int examId) {
		return entityManager
				.createQuery("select question from Question_bank question where question.exam_id.exam_id = :eId and active = 1")
				.setParameter("eId", examId)
				.getResultList();
	}

	public List<Question_bank> fetchAllQuestion() {
		return entityManager
				.createQuery("select question from Question_bank question")
				.getResultList();
	}

}