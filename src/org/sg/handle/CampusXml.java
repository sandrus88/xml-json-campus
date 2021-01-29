package org.sg.handle;

import org.xml.sax.SAXNotSupportedException;

import java.io.IOException;
import java.io.StringReader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public class CampusXml extends XmlDao {
	
	public CampusXml() throws SAXNotRecognizedException, SAXNotSupportedException {
		super();
	}
	
	public String getAllStudents() throws SAXException, IOException {
			String allStudents = "";
			parser.parse( new InputSource(new StringReader(allStudents)) );
			Document document=parser.getDocument();
			Node typePacket=document.getChildNodes().item(0);
			allStudents = typePacket.getNodeName();
		return allStudents;
	}
	
	public String getStudent() {
		return "";
	}
	
	public void removeStudent() {
		
	}
	
	public String getTopics() {
		return "";
	}
	
	public String getAllCourses() {
		return "";
	}
}
