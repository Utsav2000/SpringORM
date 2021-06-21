package com.spring.orm.dao;


import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;
@Transactional
public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public Student getsinglestudent(int studentid) {
		Student student = this.hibernateTemplate.get(Student.class, studentid);
		return student;
	}
	public  List<Student> getallstudent(){
		List<Student> loadAll = this.hibernateTemplate.loadAll(Student.class);
		return loadAll;
	}
	public void delete(int studentid) {
		Student student = this.hibernateTemplate.get(Student.class,studentid);
		this.hibernateTemplate.delete(student);
	}
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}
}
