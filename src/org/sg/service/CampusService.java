package org.sg.service;

import java.io.IOException;

import org.sg.dao.CampusDao;
import org.xml.sax.SAXException;

public class CampusService {
	public static void main(String[] args) throws SAXException, IOException {
		CampusDao campus = new CampusDao();
		campus.getStudents();
		campus.getTopics();
		campus.getCourses();
	}
}
