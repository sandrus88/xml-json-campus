package org.sg.campus.service;

import java.util.List;

import org.sg.campus.dao.CourseDao;
import org.sg.campus.dao.CourseDaoImpl;
import org.sg.campus.model.Course;

public class CourseServiceImpl implements CourseService {
	
	private CourseDao courseDao; 
	
	public CourseServiceImpl() throws Exception {
		courseDao = new CourseDaoImpl();
	}

	public void create(String id, String name, String description) {
		// TODO Auto-generated method stub
		
	}

	public void update(String id, String name, String description) {
		// TODO Auto-generated method stub
		
	}

	public List<Course> getAll() throws Exception {
		return courseDao.getAll();
	}

	public void get(String string) {
		// TODO Auto-generated method stub
		
	}
}
