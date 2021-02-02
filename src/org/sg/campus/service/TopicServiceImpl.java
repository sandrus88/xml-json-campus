package org.sg.campus.service;

import java.util.List;

import org.sg.campus.dao.TopicDao;
import org.sg.campus.dao.TopicDaoImpl;
import org.sg.campus.model.Topic;

public class TopicServiceImpl implements TopicService {
	
	private TopicDao topicDao; 
	
	public TopicServiceImpl() throws Exception {
		topicDao = new TopicDaoImpl();
	}

	public void create(String id, String name, String description, String course) {
		throw new IllegalArgumentException("ancora da implementare");
		
	}

	public void update(String id, String name, String description, String course) {
		throw new IllegalArgumentException("ancora da implementare");
		
	}

	public List<Topic> getAll() throws Exception {
		return topicDao.getAll();
	}

	public void get(String string) {
		throw new IllegalArgumentException("ancora da implementare");
		
	}
}