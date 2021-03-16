package org.sg.campus.dao.impl.domparser;

import org.w3c.dom.Document;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public abstract class DOMParserDao {
	protected Document document;

	public DOMParserDao() throws Exception {
		DOMParser parser = new DOMParser();
		parser.parse("xml/campus_list.xml");
		document = parser.getDocument();
	}
}
