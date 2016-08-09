package com.mongodb.base.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public interface BaseDAOInterface {

	public MongoDatabase getDataBase(String name);
	
	public MongoClient getClient();
	
	public void createCollection(String collectionName);
	
	public void createCollection(MongoDatabase database,String collectionName);
	
	public void dropSchema(String name);
	
	
}
