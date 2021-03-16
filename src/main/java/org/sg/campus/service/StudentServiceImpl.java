package org.sg.campus.service;

import java.util.List;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.dao.impl.domparser.StudentDaoImpl;
import org.sg.campus.model.Student;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao; 
	
	public StudentServiceImpl() throws Exception {
		studentDao = new StudentDaoImpl();
	}

	public void create(int id, String name, String surname, String jobTitle) {
		throw new IllegalArgumentException("Metodo \"create\" non implementato usando il DOMParser\n"); 
		
	}

	public void update(int id, String name, String surname, String jobTitle) {
		throw new IllegalArgumentException("Metodo \"update\" non implementato usando il DOMParser\n"); 
		
	}

	public List<Student> getAll() throws Exception {
		return studentDao.getAll();
	}

	public Student get(int id) {
		throw new IllegalArgumentException("Metodo \"get\" non implementato usando il DOMParser\n");	
	}

	@Override
	public void delete(int id) {
		throw new IllegalArgumentException("Metodo \"delete\" non implementato usando il DOMParser\n");
		
	}
}
