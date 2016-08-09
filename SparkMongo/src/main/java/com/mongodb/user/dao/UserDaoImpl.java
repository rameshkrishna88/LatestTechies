package com.mongodb.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.base.dao.BaseDAO;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.user.model.User;

public class UserDaoImpl extends BaseDAO implements UserDaoInterface {

	private static UserDaoInterface userDao = new UserDaoImpl();

	private UserDaoImpl() {

	}

	public static UserDaoInterface getInstance() {
			synchronized (userDao) {
				userDao = new UserDaoImpl();
			}

		return userDao;
	}

	@Override
	public User getUser(String id) {

		return null;
	}

	@Override
	public String createUser(User user) {

		MongoCollection<Document> collection = getCollection("cust", "user");

		return persist(user, collection);
	}

	@Override
	public String updateUser( User user) {

		MongoCollection<Document> collection = getCollection("cust", "user");
		
		FindIterable<Document> docs=collection.find(new Document("id",user.getId()));
		

 		docs.forEach(new Block<Document>() {

 			@Override
 			public void apply(Document t) {

 			   System.out.println(t.toString());
 			}
 		});	
		UpdateResult result=collection.updateMany(new Document("id",user.getId()),
				new Document("$set",new Document("username", user.getUsername()).
				append("address", user.getAddress()).append("email", user.getEmail())));
		
		return result.toString();
	}

	@Override
	public List<User> getAllUser() {

		List<User> users = new ArrayList<User>();

		MongoCollection<Document> collection = getCollection("cust", "user");

		FindIterable<Document> cursor = collection.find();

		for (Document dc : cursor) {

			users.add(new Gson().fromJson(dc.toJson(), User.class));
		}
		return users;
	}

	public static void main(String agrs[]){
		
		UserDaoInterface dao=UserDaoImpl.getInstance();
		
		dao.updateUser(new User("1","kk","Test123","aa@test123.com"));
	}

	@Override
	public String deleteUser(String id) {
		
		MongoCollection<Document> collection = getCollection("cust", "user");

		DeleteResult deleteResult=collection.deleteMany(new Document("id",id));
		return deleteResult.toString();
	}
}
