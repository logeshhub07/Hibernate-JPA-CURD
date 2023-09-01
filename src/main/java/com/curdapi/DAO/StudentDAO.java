package com.curdapi.DAO;

import com.curdapi.entity.Student;

public interface StudentDAO {
	
	void saveStudent(Student student);
	Student findById(Integer id);
	void updateStudent(Student student);
	void deleteById(Integer id);


}
