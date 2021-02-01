package org.sg.campus.service;

import java.util.List;

import org.sg.campus.dao.StudentDaoImpl;
import org.sg.campus.model.Student;

public class StudentServiceImpl implements StudentService {
	
	private StudentDaoImpl studentDao; 
	
	public StudentServiceImpl() throws Exception {
		studentDao = new StudentDaoImpl();
	}

	public void create(String id, String name, String surname, String jobTitle) {
		// TODO Auto-generated method stub
		
	}

	public void update(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		
	}

	public List<Student> getAll() throws Exception {
		return studentDao.getAll();
	}

	public void get(String string) {
		// TODO Auto-generated method stub
		
	}
}
