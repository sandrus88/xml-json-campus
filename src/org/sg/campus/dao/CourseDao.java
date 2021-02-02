package org.sg.campus.dao;

import java.util.List;

import org.sg.campus.model.Course;

public interface CourseDao {
	
	List<Course> getAll() throws Exception;
	Course get(String id);
	void create(String id, String name, String description);
	void update(String id, String name, String description);
}

