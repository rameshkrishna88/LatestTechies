package com.mongodb.base.dao;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class BaseDAO implements BaseDAOInterface {

	private static MongoClient client=null;
	
    private static final Logger logger = LoggerFactory.getLogger("logger");

	public MongoDatabase getDataBase(String name) {
		logger.info("databse  name to get connection"+ name);

		return getClient().getDatabase(name);
		
	}

	public MongoClient getClient() {
		
		if(null==client){
			client = new MongoClient("localhost", 27017);
		}
        
		return client;
	}

	@Override
	public void createCollection(MongoDatabase database,String collectionName) {

		
		database.createCollection(collectionName);
		logger.info("Collection Created"+ collectionName);
	}

	@Override
	public void createCollection(String collectionName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropSchema(String name) {

		getClient().dropDatabase(name);
		logger.info("schema dropped"+ name);

	}

	
	public MongoCollection<Document> getCollection(String db,String collection) {
		
		MongoDatabase database=getDataBase(db);
        
        MongoCollection<Document> documents= getCollection(database,collection);
        
		return documents;
	}

	
	//collection StudentInfo
	public MongoCollection<Document> getCollection(MongoDatabase database,String collection) {
		
		
		return database.getCollection(collection);
	}

 public String persist(Object object,MongoCollection<Document> collection){
	 
	 Document doc = convertDocument(object);
	 
	 collection.insertOne(doc);
	 
	return doc.toJson();
 }

public Document convertDocument(Object object) {
	String json=new Gson().toJson(object);
	 
	 Document doc=Document.parse(json);
	return doc;
}


}
