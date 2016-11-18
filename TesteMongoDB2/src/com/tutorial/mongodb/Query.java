package com.tutorial.mongodb;

import java.net.UnknownHostException;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Query {

	public static void main(String[] args) throws UnknownHostException{
		DB db = (new MongoClient("localhost",27017)).getDB("mongodb1");
		DBCollection dbCollection = db.getCollection("collection1");

		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("name", "henrique");
		
		/*
		
		DBCursor dbCursor = dbCollection.find(basicDBObject);
		
		while(dbCursor.hasNext()){
			System.out.println(dbCursor.next());
		}
		https://www.youtube.com/watch?v=dcVjEqRrI_s&list=PLSM8fkP9ppPpE7lz9GthKgvOZQD2EwqZ0&index=1
		*/
	}

	/*
	testObject.put("suitename", testsuite);
	testObject.put("testname", testcase);         
	List<BasicDBObject> milestones = new ArrayList<>();
	milestones.add(new BasicDBObject("milestone_id", "2333"));
	testObject.put("milestones", milestones);
	locations.insert(testObject);
	
	*/
	
}

