package org.sg.dto;

public class StudentDto {

	private int id;
	private String name;
	private String surname;
	private String jobTitle;
	private String paymentType;

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

	public void setSurname(String str) {
		surname = str;
	}

	public String getSurname() {
		return surname;
	}

	public void setJobTitle(String str) {
		jobTitle = str;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setPaymentType(String str) {
		paymentType = str;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public String toString() {
		return "Id = " + id + " Name = " + name + " Surname = " + surname + " Job title = " + jobTitle
				+ " Payment type = " + paymentType;
	}
}
