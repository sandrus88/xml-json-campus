package org.sg.campus.dao.impl.domparser;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.dao.TopicDao;
import org.sg.campus.model.Topic;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TopicDaoImpl extends DOMParserDao implements TopicDao {

	public TopicDaoImpl() throws Exception {
		super();
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
						dto.setCourse(Integer.parseInt(nodeContent));
					}
				}
			}
			topics.add(dto);
		}
		return topics;
	}

	@Override
	public Topic get(int id) {
		Topic topic = new Topic();
		return topic;
	}

	@Override
	public void create(int id, String name, String description, int course) {
		
//		document.createElement("topic");
		throw new IllegalArgumentException("Metodo \"create\" non implementato usando il DOMParser\n");
	}

	@Override
	public void update(int id, String name, String description, int course) {
		throw new IllegalArgumentException("Metodo \"update\" non implementato usando il DOMParser\n");
	}
	
	public void delete(int id) {
		throw new IllegalArgumentException("Metodo \"delete\" non implementato usando il DOMParser\n");	
	}
}