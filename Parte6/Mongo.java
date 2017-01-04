package br.inpe.lac;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Mongo {
    MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017/teste");
    MongoClient mongoClient = new MongoClient();
    
    public void adicionarPessoa(Document pessoa){
        MongoDatabase banco = mongoClient.getDatabase(uri.getDatabase());
        MongoCollection<Document> pessoas = banco.getCollection("pessoas");
        pessoas.insertOne(pessoa);
    }
    
    
    public FindIterable<Document> procurarPeloNome(String nome){
        MongoDatabase banco = mongoClient.getDatabase(uri.getDatabase());
        MongoCollection<Document> pessoas = banco.getCollection("pessoas");
        
        FindIterable<Document> resultado = pessoas.find(new Document("nome", nome));
        return resultado;
    } 
}
