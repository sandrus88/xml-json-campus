package org.sg.campus.dao;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.model.Student;
import org.sg.util.SGUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class StudentDaoImpl implements StudentDao{
	public Document document;

	public StudentDaoImpl() throws Exception {
		DOMParser parser = new DOMParser();
		parser.parse("xml/campus_list.xml");
		document = parser.getDocument();
	}

	public List<Student> getAll() throws Exception {
		List<Student> students = new ArrayList<Student>();
		NodeList studentsList = document.getElementsByTagName("student");
		for (int i = 0; i < studentsList.getLength(); i++) {
			Student dto = new Student();
			Node studentNode = studentsList.item(i);
			NodeList studentFieldsList = studentNode.getChildNodes();
			for (int j = 0; j < studentFieldsList.getLength(); j++) {
				Node fieldElement = studentFieldsList.item(j);// <id></id>, <name></name>, etc
				if (fieldElement.getNodeType() == Node.ELEMENT_NODE) {
					String nodeName = fieldElement.getNodeName();
					String nodeContent = fieldElement.getTextContent();
					if (nodeName.equals("id")) {
						dto.setId(Integer.parseInt(nodeContent));
					} else if (nodeName.equals("name")) {
						dto.setName(nodeContent);
					} else if (nodeName.equals("surname")) {
						dto.setSurname(nodeContent);
					} else if (nodeName.equals("jobTitle")) {
						dto.setJobTitle(nodeContent);
					} else if (nodeName.equals("paymentType")) {
						dto.setPaymentType(nodeContent);
					}
				}
			}
			students.add(dto);	
		}
		return students;
	}	

	@Override
	public void get(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(String id, String name, String surname, String jobTitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String id, String name, String surname, String jobTitle) {
		// TODO Auto-generated method stub
		
	}
}