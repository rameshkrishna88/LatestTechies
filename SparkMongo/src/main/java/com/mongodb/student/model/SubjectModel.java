package com.mongodb.student.model;

public class SubjectModel{

	private String subjectName;
	private double score;
	
	
	public SubjectModel(String subjectName, double score) {
		super();
		this.subjectName = subjectName;
		this.score = score;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "SubjectModel [subjectName=" + subjectName + ", score=" + score + "]";
	}
	
	
}
