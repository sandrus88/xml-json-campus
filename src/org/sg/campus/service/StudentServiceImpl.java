package org.sg.campus.service;

import java.util.List;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.dao.StudentDaoImpl;
import org.sg.campus.model.Student;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao; 
	
	public StudentServiceImpl() throws Exception {
		studentDao = new StudentDaoImpl();
	}

	public void create(String id, String name, String surname, String jobTitle) {
		throw new IllegalArgumentException("ancora da implementare"); 
		
	}

	public void update(String string, String string2, String string3, String string4) {
		throw new IllegalArgumentException("ancora da implementare"); 
		
	}

	public List<Student> getAll() throws Exception {
		return studentDao.getAll();
	}

	public void get(String string) {
		throw new IllegalArgumentException("ancora da implementare");
		
	}
}