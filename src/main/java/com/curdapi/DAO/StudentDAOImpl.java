package com.curdapi.DAO;

import org.springframework.stereotype.Repository;

import com.curdapi.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository //support component scanning
public class StudentDAOImpl implements StudentDAO {

	//define entity manager
	private EntityManager entityManager;
	
	//constructor injuction
	public StudentDAOImpl(EntityManager myEntityManager) {
		entityManager = myEntityManager;
	}
	
	//implementing save method
	@Override
	@Transactional
	public void saveStudent(Student student) {
		entityManager.persist(student);
		
	}
	//implementing find method
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
		
		
	}
	//implementing update method
	@Override
	@Transactional
	public void updateStudent(Student student) {
		entityManager.merge(student);
	}

	//implementing delete method
	@Override
	@Transactional
	public void deleteById(Integer id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
		
	}

}
