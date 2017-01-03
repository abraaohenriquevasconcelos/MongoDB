package br.inpe.lac;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


public class Main {
    private static final DB BANCO = (new MongoClient("localhost", 27017)).getDB("teste");
    private static final DBCollection PESSOAS = BANCO.getCollection("pessoas");
    
    public static void main(String[] args) {
        inserirJãoEDudinha();
    }
    
    
    
    
    
    public static void inserirJãoEDudinha(){
        List<BasicDBObject> cursos = new ArrayList<>();
        cursos.add(new BasicDBObject("nome", "Trigonometria").append("tipo", "matematica"));
        cursos.add(new BasicDBObject("nome", "MongoDB").append("tipo", "informática"));
    
        BasicDBObject Jão = new BasicDBObject("_id", 3)
        .append("nome", "Jão da Raça")
        .append("salario", 600.45)
        .append("endereço", new BasicDBObject("rua", "Rua Reta").append("bairro", "Beco 31").append("numero", 30))
        .append("cursos", cursos);
        
        PESSOAS.insert(Jão);
        
        String json = "{'_id':4, 'nome':'Bernardete Topa Tudo', 'salario':6834.76, 'endereço':{'rua':'Rua da Farra', 'bairro':'Bairro Bom', 'numero':666}, 'cursos':[{'nome':'Java', 'tipo':'informatica'},{'nome':'Pin Pong', 'tipo':'jogo'}]}";
        
        BasicDBObject Dudinha = (BasicDBObject) JSON.parse(json); //parse(String): Object
        PESSOAS.insert(Dudinha);
    }
}
