package org.sg.campus.dao.impl.domparser;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.dao.CourseDao;
import org.sg.campus.model.Course;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CourseDaoImpl extends DOMParserDao implements CourseDao {
	public CourseDaoImpl() throws Exception {
		super();
	}

	public List<Course> getAll() {
		List<Course> courses = new ArrayList<Course>();
		NodeList coursesList = document.getElementsByTagName("course");
		for (int i = 0; i < coursesList.getLength(); i++) {
			int id = 0;
			String name = "";
			String description = null;
			Node courseNode = coursesList.item(i);
			NodeList courseFieldsList = courseNode.getChildNodes();
			for (int j = 0; j < courseFieldsList.getLength(); j++) {
				Node fieldElement = courseFieldsList.item(j);
				if (fieldElement.getNodeType() == Node.ELEMENT_NODE) {
					String attrId = fieldElement.getAttributes().getNamedItem("id").getNodeValue();
					String nodeName = fieldElement.getNodeName();
					String nodeContent = fieldElement.getTextContent();
					if (nodeName.equals("id")) {
						id = Integer.parseInt(attrId);
					} else if (nodeName.equals("name")) {
						name = nodeContent;
					} else if (nodeName.equals("description")) {
						description = nodeContent;
					}
				}
			}
			if (!name.equals("")) {
				Course dto = new Course(id, name, description);
				courses.add(dto);
			}
		}
		return courses;
	}

	public Course get(int id) {
		Course course = new Course();
		return course;
	}

	@Override
	public void create(int id, String name, String description) {
		throw new IllegalArgumentException("Metodo \"create\" non implementato usando il DOMParser\n");

	}

	@Override
	public void update(int id, String name, String description) {
		throw new IllegalArgumentException("Metodo \"update\" non implementato usando il DOMParser\n");

	}
	
	public void delete(int id) {
		throw new IllegalArgumentException("Metodo \"delete\" non implementato usando il DOMParser\n");	
	}
}
