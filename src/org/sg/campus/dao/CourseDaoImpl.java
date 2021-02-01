package org.sg.campus.dao;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.model.Course;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class CourseDaoImpl implements CourseDao {
	public Document document;

	public CourseDaoImpl() throws Exception {
		DOMParser parser = new DOMParser();
		parser.parse("xml/campus_list.xml");
		document = parser.getDocument();
	}

	public List<Course> getAll() {
		List<Course> courses = new ArrayList<Course>();
		NodeList coursesList = document.getElementsByTagName("course");
		for (int i = 0; i < coursesList.getLength(); i++) {
			int id = -1;
			String name = null;
			String description = null;
			Node courseNode = coursesList.item(i);
			NodeList courseFieldsList = courseNode.getChildNodes();
			for (int j = 0; j < courseFieldsList.getLength(); j++) {
				Node fieldElement = courseFieldsList.item(j);
				if (fieldElement.getNodeType() == Node.ELEMENT_NODE) {
					String nodeName = fieldElement.getNodeName();
					String nodeContent = fieldElement.getTextContent();
					if (nodeName.equals("id")) {
						id = Integer.parseInt(nodeContent);
					} else if (nodeName.equals("name")) {
						name = nodeContent;
					} else if (nodeName.equals("description")) {
						description = nodeContent;
					}
				}
			}
			if (id != -1) {
				Course dto = new Course(id, name, description);
				courses.add(dto);
			}
		}
		return courses;
	}

	@Override
	public void get(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(String id, String name, String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String id, String name, String description) {
		// TODO Auto-generated method stub

	}
}
