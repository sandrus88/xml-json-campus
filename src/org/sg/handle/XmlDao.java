package org.sg.handle;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class XmlDao {
	public DOMParser parser;
	private final String schema_properties = "../../xml/campus_list.xml";
    private final String XMLSchema = "../../xsd/schema-online-campus.xsd";
	
	public XmlDao() throws SAXNotRecognizedException, SAXNotSupportedException {
		this.parser = new DOMParser();
		this.parser.setProperty(schema_properties, XMLSchema);
	}
}
