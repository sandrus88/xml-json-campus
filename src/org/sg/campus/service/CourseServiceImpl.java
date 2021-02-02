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

	public void create(String id, String name, String description) {
		throw new IllegalArgumentException("Metodo \"create\" non implementato usando il DOMParser\n");
		
	}

	public void update(String id, String name, String description) {
		throw new IllegalArgumentException("Metodo \"update\" non implementato usando il DOMParser\n");
		
	}

	public List<Course> getAll() throws Exception {
		return courseDao.getAll();
	}

	public void get(String string) {
		throw new IllegalArgumentException("Metodo \"get\" non implementato usando il DOMParser\n");
		
	}
}
