package com.freshdirect.service;

import java.util.List;

import com.mongodb.helper.Counter;
import com.mongodb.user.dao.UserDaoImpl;
import com.mongodb.user.dao.UserDaoInterface;
import com.mongodb.user.model.User;

public class UserService {


	public static UserDaoInterface  userDao=UserDaoImpl.getInstance();
	
	public List<User> getAllUsers() {
		
		return userDao.getAllUser();
	}

	public User getUser(String id) {
		return userDao.getUser(id);
	}

	public User createUser(User user) {
		failIfInvalid(user.getUsername(), user.getEmail());
		user.setId(String.valueOf(Counter.getUserCounter()));
		//users.put(Long.toString(user.getId()), user);
		
		userDao.createUser(user);
		return user;
	}

	public User updateUser(User user) {
		
		failIfInvalid(user.getUsername(), user.getEmail());

		userDao.updateUser(user);
		
		return user;
	}


	public User deleteUser(User user) {
		

		userDao.deleteUser(user.getId());
		
		return user;
	}
	
	private void failIfInvalid(String name, String email) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'name' cannot be empty");
		}
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'email' cannot be empty");
		}
	}
}