package org.sg.campus.model;

public class Course {

	private int id;
	private String name;
	private String description;
	
	public Course () {
		
	}
	
	public Course(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String toString() {
		return "course[id: " + id + ", name: " + name + ", description: " + description + "]";
	}
}
