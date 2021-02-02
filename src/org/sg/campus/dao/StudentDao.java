package org.sg.campus.dao;

import java.util.List;

import org.sg.campus.model.Student;

public interface StudentDao {
	
	List<Student> getAll() throws Exception;
	Student get(String string);
	void create(String id, String name, String surname, String jobTitle);
	void update(String id, String name, String surname, String jobTitle);
}
