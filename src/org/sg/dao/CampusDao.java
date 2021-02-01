package org.sg.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sg.dto.CourseDto;
import org.sg.dto.StudentDto;
import org.sg.dto.TopicDto;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class CampusDao {
	public Document document;

	public CampusDao() throws SAXException, IOException {
		DOMParser parser = new DOMParser();
		parser.parse("xml/campus_list.xml");
		document = parser.getDocument();
	}

	public List<StudentDto> getStudents() throws SAXException, IOException {
		List<StudentDto> students = new ArrayList<StudentDto>();
		NodeList studentsList = document.getElementsByTagName("students");
		Node studentsNode = studentsList.item(0);
//		System.out.println(studentsNode);
		studentsList = studentsNode.getChildNodes();
		for (int i = 1; i < studentsList.getLength(); i++) {
			StudentDto dto = new StudentDto();
			Node studentNode = studentsList.item(i);
//			System.out.println(studentNode);
			NodeList studentList = studentNode.getChildNodes();
			for (int y = 0; y < studentList.getLength(); y++) {
				Node insideStudent = studentList.item(y);
				NodeList nodelist = insideStudent.getChildNodes();
				Node node = nodelist.item(0);
				
				if (insideStudent.getNodeType() == Node.ELEMENT_NODE) {
					String s = insideStudent.getNodeName();
					String value = node.getTextContent();
//					System.out.println(value);
					if (s.equals("id")) {
						dto.setId(Integer.parseInt(value));
					} else if (s.equals("name")) {
						dto.setName(value);
					} else if (s.equals("surname")) {
						dto.setSurname(value);
					} else if (s.equals("jobTitle")) {
						dto.setJobTitle(value);
					} else if (s.equals("paymentType")) {
						dto.setPaymentType(value);
					}
				}
			}
			students.add(dto);
		}
		System.out.println(students);
		return students;
	}

	public List<TopicDto> getTopics() {
		List<TopicDto> topics = new ArrayList<TopicDto>();
		NodeList topicsList = document.getElementsByTagName("topics");
		Node topicsNode = topicsList.item(0);
//		System.out.println(studentsNode);
		topicsList = topicsNode.getChildNodes();
		for (int i = 0; i < topicsList.getLength(); i++) {
			TopicDto dto = new TopicDto();
			Node topicNode = topicsList.item(i);
//			System.out.println(studentNode);
			NodeList topicList = topicNode.getChildNodes();
			for (int y = 0; y < topicList.getLength(); y++) {
				Node insideTopic = topicList.item(y);
				NodeList nodelist = insideTopic.getChildNodes();
				Node node = nodelist.item(0);
				if (insideTopic.getNodeType() == Node.ELEMENT_NODE) {
					String s = insideTopic.getNodeName();
					String value = node.getTextContent();
//					System.out.println(value);
					if (s.equals("id")) {
						dto.setId(Integer.parseInt(value));
					} else if (s.equals("name")) {
						dto.setName(value);
					} else if (s.equals("description")) {
						dto.setDescription(value);
					} else if (s.equals("course")) {
						dto.setCourse(value);
					}
				}
			}
			topics.add(dto);
		}
		System.out.println(topics);
		return topics;
	}

	public List<CourseDto> getCourses() {
		List<CourseDto> courses = new ArrayList<CourseDto>();
		NodeList coursesList = document.getElementsByTagName("courses");
		Node coursesNode = coursesList.item(0);
//		System.out.println(studentsNode);
		coursesList = coursesNode.getChildNodes();
		for (int i = 0; i < coursesList.getLength(); i++) {
			CourseDto dto = new CourseDto();
			Node courseNode = coursesList.item(i);
//			System.out.println(studentNode);
			NodeList courseList = courseNode.getChildNodes();
			for (int y = 0; y < courseList.getLength(); y++) {
				Node insideCourse = courseList.item(y);
				NodeList nodelist = insideCourse.getChildNodes();
				Node node = nodelist.item(0);
				if (insideCourse.getNodeType() == Node.ELEMENT_NODE) {
					String s = insideCourse.getNodeName();
					String value = node.getTextContent();
//					System.out.println(value);
					if (s.equals("id")) {
						dto.setId(Integer.parseInt(value));
					} else if (s.equals("name")) {
						dto.setName(value);
					} else if (s.equals("description")) {
						dto.setDescription(value);
					}
				}
			}
			courses.add(dto);
		}
		System.out.println(courses);
		return courses;
	}

	public void removeStudent() {

	}

	public void removeTopic() {

	}

	public void removeCourse() {

	}
}