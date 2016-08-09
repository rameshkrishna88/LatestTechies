package com.mongodb.student.model;

import java.util.ArrayList;
import java.util.List;

public class Semester {

	private  int semesterId ;
	
	List<SubjectModel> subjectModels=new ArrayList<SubjectModel>();

	
	public Semester(int semesterId) {
		super();
		this.semesterId = semesterId;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public List<SubjectModel> getSubjectModels() {
		return subjectModels;
	}

	public void setSubjectModels(List<SubjectModel> subjectModels) {
		this.subjectModels = subjectModels;
	}

	@Override
	public String toString() {
		return "Semester [semesterId=" + semesterId + ", subjectModels=" + subjectModels + "]";
	}
	
	
} 
