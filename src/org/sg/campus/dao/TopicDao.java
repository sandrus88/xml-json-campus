package org.sg.campus.dao;

import java.util.List;

import org.sg.campus.model.Topic;

public interface TopicDao {
	
	List<Topic> getAll() throws Exception;
	Topic get(int id);
	void create(int id, String name, String description, int course);
	void update(int id, String name, String description, int course);
}
