package com.mongodb.student.dao;

import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.Block;
import com.mongodb.base.dao.BaseDAO;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.student.model.StudentDetailModel;

public class StudentDaoImpl extends BaseDAO implements StudentDaoInterface{

    private static final Logger logger = LoggerFactory.getLogger("logger");

	@Override
	public List<StudentDetailModel> getAllStudentDetails() {
		
        MongoCollection<Document> documents = getCollection("cust","StudentInfo");
		
        FindIterable<Document> cursor=documents.find();

    		cursor.forEach(new Block<Document>() {

    			@Override
    			public void apply(Document t) {

    				logger.info(t.toString());
    			}
    		});	

		return null;
	}






	



	@Override
	public StudentDetailModel getStudentDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createStudent(StudentDetailModel detailModel) {
		 MongoCollection<Document> document = getCollection("cust","StudentInfo");;
		 
		 
		return persist(detailModel, document);
	}


	@Override
	public String updateStudent(StudentDetailModel detailModel) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteStudent(StudentDetailModel detailModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String args[]){
		
		StudentDaoImpl dao=new StudentDaoImpl();
		
		dao.getAllStudentDetails();
		
		//MongoDatabase database=dao.getDB();
		
		//dao.createCollection(database,"studentInfo");
		
	//	List<StudentDetailModel> detailModels =StudentHelper.populateStudentDetails();
		
	//	for(StudentDetailModel detailModel:detailModels){
			
		//	dao.createStudent(detailModel);
		//}
	}
}
