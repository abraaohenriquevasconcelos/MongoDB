package br.edu.fatec;

import java.util.List;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Conexao {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		DB my_db = mongoClient.getDB("bancoMongoDB1");
		
		List<String> allDatabases = mongoClient.getDatabaseNames();
		System.out.println(allDatabases);
		
		System.out.println(my_db);
		
		System.out.println(my_db.collectionExists("usuarios"));
		
		System.out.println(my_db.command("usuarios.find()"));
		//@@@@
	}

}
