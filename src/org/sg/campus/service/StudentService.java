package org.sg.campus.service;

import java.util.List;

import org.sg.campus.model.Student;

public interface StudentService {
	
	List<Student> getAll() throws Exception;
	Student get(int id);
	void create(int id, String name, String surname, String jobTitle);
	void update(int id, String name, String surname, String jobTitle);
	void delete(int id);
}
