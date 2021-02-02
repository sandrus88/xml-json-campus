package org.sg.campus.service;

import java.util.List;

import org.sg.campus.model.Course;

public interface CourseService {
	
	List<Course> getAll() throws Exception;
	Course get(int id);
	void create(int id, String name, String description);
	void update(int id, String name, String description);
	void delete(int id);
}
