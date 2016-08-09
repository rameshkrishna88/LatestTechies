package com.mongodb.user.dao;

import java.util.List;

import com.mongodb.base.dao.BaseDAOInterface;
import com.mongodb.user.model.User;

public interface UserDaoInterface extends BaseDAOInterface{

	
	public User getUser(String id) ;
	

	public String createUser( User user) ;


	public String updateUser( User user) ;
	
	
	public List<User> getAllUser();


	public String deleteUser(String id);
	
	
}
