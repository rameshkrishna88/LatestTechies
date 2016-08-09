package com.mongodb.helper;

public class Counter {

	public static volatile Long userCouner= 0L;
	
	
	public static Long getUserCounter(){
		synchronized (userCouner) {
			return userCouner=userCouner+1;
		}
	}
}
