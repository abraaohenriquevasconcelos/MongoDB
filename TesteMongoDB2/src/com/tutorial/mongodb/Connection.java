package com.tutorial.mongodb;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Connection {
	//At this point, the db object will be a connection to a 
	//MongoDB server for the specified database.
	
	/*The MongoClient class is designed to be thread safe and 
	 shared among threads. */
	
	/*
	 MongoClient mongoCliente = new MongoClient("localhost", 27017);
	 DB db = mongoClient.getDB 
	*/
	public static void main(String[] args) throws UnknownHostException{
		DB db = (new MongoClient("localhost",27017)).getDB("mongodb1");
		DBCollection dbCollection = db.getCollection("collection1");
		
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("name", "henrique");
		basicDBObject.put("age", 22);
		
		dbCollection.insert(basicDBObject);
	
		DBCursor dbCursor = dbCollection.find(basicDBObject);
		
		while(dbCursor.hasNext()){
			System.out.println(dbCursor.next());
		}
	}
	
}
