package org.sg.campus.service;

import java.util.List;

import org.sg.campus.dao.TopicDao;
import org.sg.campus.dao.impl.domparser.TopicDaoImpl;
import org.sg.campus.model.Topic;

public class TopicServiceImpl implements TopicService {
	
	private TopicDao topicDao; 
	
	public TopicServiceImpl() throws Exception {
		topicDao = new TopicDaoImpl();
	}

	public void create(String id, String name, String description, String course) {
		throw new IllegalArgumentException("Metodo \"create\" non implementato usando il DOMParser\n");
		
	}

	public void update(String id, String name, String description, String course) {
		throw new IllegalArgumentException("Metodo \"update\" non implementato usando il DOMParser\n");
		
	}

	public List<Topic> getAll() throws Exception {
		return topicDao.getAll();
	}

	public void get(String string) {
		throw new IllegalArgumentException("Metodo \"get\" non implementato usando il DOMParser\n");
		
	}

	@Override
	public void delete(String id) {
		throw new IllegalArgumentException("Metodo \"delete\" non implementato usando il DOMParser\n");
		
	}
}