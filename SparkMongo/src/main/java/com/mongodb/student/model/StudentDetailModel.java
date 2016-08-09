package com.mongodb.student.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailModel{

	private String name;
	private int rollnumber;
	private String courseName;  //CSE,ECE,EEE,MCE
	
	
	public StudentDetailModel(String name, int rollnumber, String courseName, List<Semester> semesters) {
		super();
		this.name = name;
		this.rollnumber = rollnumber;
		this.courseName = courseName;
		this.semesters = semesters;
	}
	public StudentDetailModel(String name, int rollnumber, String courseName) {
		super();
		this.name = name;
		this.rollnumber = rollnumber;
		this.courseName = courseName;
	}
	private List<Semester> semesters=new ArrayList<Semester>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}
	@Override
	public String toString() {
		return "StudentDetailModel [name=" + name + ", rollnumber=" + rollnumber + ", courseName=" + courseName
				+ ", semesters=" + semesters + "]";
	}

	
	
	
}
