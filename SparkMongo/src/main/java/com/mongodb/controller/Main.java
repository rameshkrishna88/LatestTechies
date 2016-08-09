package com.mongodb.controller;

import com.freshdirect.service.UserService;

import spark.Spark;

public class Main {
	public static void main(String[] args) {

		new UserController(new UserService());
	}
}
