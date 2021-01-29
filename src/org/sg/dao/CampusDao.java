package org.sg.dao;

import java.io.File;
import java.io.IOException;

import org.sg.dto.StudentDto;
import org.sg.service.CampusService;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

abstract public class CampusDao {
	CampusService campus = new CampusService();
	public DOMParser parser;
	public Document document = parser.getDocument();
	private final String fileXml = new File("../../xml/campus_list.xml").getName();
	private final String xmlSchema = new File("../../xsd/schema-online-campus.xsd").getName();

	public CampusDao() throws SAXException, IOException {
		String s = "";
		this.parser = new DOMParser();
		this.parser.setProperty(fileXml, xmlSchema);
		parser.parse(s);
	}

//	public StudentDto getStudent() throws SAXException, IOException {
//		Node node = document.getChildNodes().item(0);
//		return student;
//	}

	public String getTopic() {
		return "";
	}

	public String getCourse() {
		return "";
	}

	public String getAllStudents() {
		return "";
	}

	public String getAllTopics() {
		return "";
	}

	public String getAllCourses() {
		return "";
	}

	public void removeStudent() {

	}

}