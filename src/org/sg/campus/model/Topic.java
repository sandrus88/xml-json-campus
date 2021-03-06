package org.sg.campus.model;

public class Topic {

	private int id;
	private String name;
	private String description;
	private int course;

	public Topic() {
		
	}
	
	public Topic(int id, String name, String description, int course) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.course = course;
	}
	
	public void setId(int x) {
		id = x;
	}

	public int getId() {
		return id;
	}

	public void setName(String str) {
		name = str;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String str) {
		description = str;
	}

	public String getDescription() {
		return description;
	}

	public void setCourse(int i) {
		course = i;
	}

	public int getCourse() {
		return course;
	}

	public String toString() {
		return "topic[id: " + id + ", name: " + name + ", description: " + description + ", course: " + course + "]";
	}
}
