package org.sg.campus.dao;

import java.util.List;

import org.sg.campus.model.Student;

public interface StudentDao {
	
	List<Student> getAll() throws Exception;
	Student get(int id) throws Exception;
	void create(int id, String name, String surname, String jobTitle) throws Exception;
	void update(int id, String name, String surname, String jobTitle);
}
