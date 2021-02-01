package org.sg.campus.service;

import java.util.List;

import org.sg.campus.model.Course;

public interface CourseService {
	
	List<Course> getAll() throws Exception;
	void get(String string);
	void create(String id, String name, String description);
	void update(String id, String name, String description);
}
