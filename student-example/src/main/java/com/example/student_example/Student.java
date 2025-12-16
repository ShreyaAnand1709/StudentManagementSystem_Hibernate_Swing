package com.example.student_example;


import jakarta.persistence.*;
@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@Column
	String email;
	@Column
	String course;
	@Column
	int age;
	@Column
	String studentcol;
	public Student() {
		
	}
	public Student(String name, String email, String course, int age, String studentcol) {
		super();
		this.name = name;
		this.email = email;
		this.course = course;
		this.age = age;
		this.studentcol = studentcol;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStudentcol() {
		return studentcol;
	}
	public void setStudentcol(String studentcol) {
		this.studentcol = studentcol;
	}
	
	
	
	
}
