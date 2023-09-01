package com.curdapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.curdapi.DAO.StudentDAO;
import com.curdapi.entity.Student;

@SpringBootApplication
public class CurdAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			 multipleStudent(studentDAO);
			// readStudent(studentDAO);
			//updateStudent(studentDAO);
			//removeStudent(studentDAO);
		};
	}
	//
	private void removeStudent(StudentDAO studentDAO) {
		//deleting the id:
		int removeid=3;
		System.out.println("deleting the id: "+removeid);
		studentDAO.deleteById(removeid);
		
		
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retriving the primary key
		int theId = 1;
		Student myStudent = studentDAO.findById(theId);

		// updating the firstname
		myStudent.setFirstName("abishake");
		studentDAO.updateStudent(myStudent);

		// updated student
		System.out.println("updated student: " + myStudent);
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("creating multiple students");
		Student tempStudent = new Student("ashok", "kumar", "ashok@gmail.com");

		// save the student object
		System.out.println("saving the students");
		studentDAO.saveStudent(tempStudent);

		// display student
		int theId = tempStudent.getId();
		Student myStudent = studentDAO.findById(theId);

		System.out.println("recently added student details: " + myStudent);

	}

	private void multipleStudent(StudentDAO studentDAO) {
		System.out.println("creating multiple students");
		Student tempStudent = new Student("balaji", "shankar", "balaji@gmail.com");
		Student tempStudent1 = new Student("vignesh", "waran", "vignesh@gmail.com");
		Student tempStudent2 = new Student("bala", "dhinesh", "dhinesh@gmail.com");
		Student tempStudent3 = new Student("prathip", "kumar", "kumar@gmail.com");

		System.out.println("saving all the students student");
		studentDAO.saveStudent(tempStudent);
		studentDAO.saveStudent(tempStudent1);
		studentDAO.saveStudent(tempStudent2);
		studentDAO.saveStudent(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("creating student");
		Student tempStudent = new Student("hari", "kumar", "hari@gmail.com");

		// save student
		System.out.println("saving student");
		studentDAO.saveStudent(tempStudent);

		// displaying id
		System.out.println("saved student Id: " + tempStudent.getId());
	}

}
