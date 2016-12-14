package com.tutorial.mongodb;

import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Conexao2 {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB my_db = mongoClient.getDB("journaldev");
		Set<String> colecoes = my_db.getCollectionNames();
		System.out.println (colecoes);
		
		DBCollection collection1 = my_db.getCollection("usuarios");
		Set<String> colecoes2 = my_db.getCollectionNames();
		System.out.println (colecoes2);
	}

}
