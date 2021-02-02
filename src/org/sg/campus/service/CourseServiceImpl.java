package org.sg.campus.service;
// cambiare i metodi get

// creare classe abstract padre con DOMParserDao
//public Document document;
//
//public DOMParserDao() throws Exception {
//	DOMParser parser = new DOMParser();
//	parser.parse("xml/campus_list.xml");
//	document = parser.getDocument();
//}

// per ogni sottoclasse dao creare un costruttore vuoto che chiami il super().
import java.util.List;

import org.sg.campus.dao.CourseDao;
import org.sg.campus.dao.impl.domparser.CourseDaoImpl;
import org.sg.campus.model.Course;
import org.w3c.dom.Document;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

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

	public Course get(String id) {
		return null;
	}

	@Override
	public void delete(String id) {
		throw new IllegalArgumentException("Metodo \"delete\" non implementato usando il DOMParser\n");	
	}
}
