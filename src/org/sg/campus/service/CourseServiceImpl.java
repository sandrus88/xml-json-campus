package org.sg.campus.service;

import java.util.List;

import org.sg.campus.dao.CourseDao;
import org.sg.campus.dao.impl.domparser.CourseDaoImpl;
import org.sg.campus.model.Course;

public class CourseServiceImpl implements CourseService {
	
	private CourseDao courseDao; 
	
	public CourseServiceImpl() throws Exception {
		courseDao = new CourseDaoImpl();
	}

	public void create(int id, String name, String description) {
		throw new IllegalArgumentException("Metodo \"create\" non implementato usando il DOMParser\n");
		
	}

	public void update(int id, String name, String description) {
		throw new IllegalArgumentException("Metodo \"update\" non implementato usando il DOMParser\n");
		
	}

	public List<Course> getAll() throws Exception {
		return courseDao.getAll();
	}

	public Course get(int id) {
		return null;
	}

	@Override
	public void delete(int id) {
		throw new IllegalArgumentException("Metodo \"delete\" non implementato usando il DOMParser\n");	
	}
}
