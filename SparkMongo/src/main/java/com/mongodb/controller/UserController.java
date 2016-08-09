package com.mongodb.controller;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;

import com.freshdirect.service.UserService;
import com.google.gson.Gson;
import com.mongodb.helper.JsonUtil;
import com.mongodb.helper.ResponseError;
import com.mongodb.user.model.User;

import spark.Filter;
import spark.Request;
import spark.Response;

public class UserController {

	public UserController(final UserService userService) {

		before(new Filter() {
			
			@Override
			public void handle(Request request, Response response) throws Exception {
					
			}
		});
		get("/users", (req, res) -> {
			return userService.getAllUsers();
			}, JsonUtil.json());

		get("/users/:id", (req, res) -> {
			String id = req.params(":id");
			User user = userService.getUser(id);
			if (user != null) {
				return user;
			}
			res.status(400);
			return new ResponseError("No user with id '%s' found", id);
		}, JsonUtil.json());

		post("/users/create", (req, res) -> {
	        User user = new Gson().fromJson(req.body(), User.class);
	   
			 user=userService.createUser(user);
			return user;
		}, JsonUtil.json());

		post("/users/update", (req, res) ->
			userService.updateUser(new Gson().fromJson(req.body(), User.class) )
			, JsonUtil.json());

		post("/users/delete", (req, res) ->
		userService.deleteUser(new Gson().fromJson(req.body(), User.class) )
		, JsonUtil.json());
		
		
		after((req, res) -> {
			res.type("application/json");
			res.status(200);
			corsHeaders.forEach((key, value) -> {
                res.header(key, value);
            });
		});

		exception(Exception.class, (e, req, res) -> {
			res.status(400);
			res.body(JsonUtil.toJson(new ResponseError(e)));
		});
	}

	
    private static final HashMap<String, String> corsHeaders = new HashMap<String, String>();
    
    static {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "*");
        corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");
    }
}