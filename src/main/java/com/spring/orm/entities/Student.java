package com.spring.orm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	@Id
	private int id;
	private String student_name;
	private String student_city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_city() {
		return student_city;
	}
	public void setStudent_city(String student_city) {
		this.student_city = student_city;
	}
	public Student(int id, String student_name, String student_city) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.student_city = student_city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
