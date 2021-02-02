package org.sg.campus.service;

import java.util.List;

import org.sg.campus.model.Student;

public interface StudentService {
	
	List<Student> getAll() throws Exception;
	void get(String string);
	void create(String id, String name, String description, String course);
	void update(String id, String name, String description, String course);
	void delete(String id);
}
