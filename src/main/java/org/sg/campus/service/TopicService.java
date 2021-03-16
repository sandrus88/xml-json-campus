package org.sg.campus.service;

import java.util.List;

import org.sg.campus.model.Topic;

public interface TopicService {
	
	List<Topic> getAll() throws Exception;
	void get(int id);
	void create(int id, String name, String description, int course);
	void update(int id, String name, String description, int course);
	void delete(int id);
}
