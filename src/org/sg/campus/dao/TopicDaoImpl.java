package org.sg.campus.dao;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.model.Topic;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class TopicDaoImpl implements TopicDao {
	public Document document;

	public TopicDaoImpl() throws Exception {
		DOMParser parser = new DOMParser();
		parser.parse("xml/campus_list.xml");
		document = parser.getDocument();
	}

	public List<Topic> getAll() throws Exception {
		List<Topic> topics = new ArrayList<Topic>();
		NodeList topicsList = document.getElementsByTagName("topic");
		for (int i = 0; i < topicsList.getLength(); i++) {
			Topic dto = new Topic();
			Node topicNode = topicsList.item(i);
			NodeList topicFieldsList = topicNode.getChildNodes();
			for (int j = 0; j < topicFieldsList.getLength(); j++) {
				Node fieldElement = topicFieldsList.item(j);
				if (fieldElement.getNodeType() == Node.ELEMENT_NODE) {
					String nodeName = fieldElement.getNodeName();
					String nodeContent = fieldElement.getTextContent();
					if (nodeName.equals("id")) {
						dto.setId(Integer.parseInt(nodeContent));
					} else if (nodeName.equals("name")) {
						dto.setName(nodeContent);
					} else if (nodeName.equals("description")) {
						dto.setDescription(nodeContent);
					} else if (nodeName.equals("course")) {
						dto.setCourse(nodeContent);
					}
				}
			}
			topics.add(dto);
		}
		return topics;
	}

	@Override
	public void get(String string) {
		throw new IllegalArgumentException("ancora da implementare");
	}

	@Override
	public void create(String id, String name, String description, String course) {
		throw new IllegalArgumentException("ancora da implementare");
	}

	@Override
	public void update(String id, String name, String description, String course) {
		throw new IllegalArgumentException("ancora da implementare");
	}
}