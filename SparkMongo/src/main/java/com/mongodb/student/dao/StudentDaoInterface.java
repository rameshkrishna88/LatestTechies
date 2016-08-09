package com.mongodb.student.dao;

import java.util.List;

import com.mongodb.base.dao.BaseDAOInterface;
import com.mongodb.student.model.StudentDetailModel;

public interface StudentDaoInterface extends BaseDAOInterface{

	public StudentDetailModel getStudentDetail();
	
	public List<StudentDetailModel> getAllStudentDetails();
	
	public String createStudent(StudentDetailModel detailModel);
	
	public String updateStudent(StudentDetailModel detailModel);
	
	public String deleteStudent(StudentDetailModel detailModel);
	
	

}
