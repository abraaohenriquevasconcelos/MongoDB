package br.inpe.lac;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
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
        //procurarTodasAsPessoas();
        //pegarABernardete();
        //pegaOsRicosCom$gt();
        pega_pessoas_com_$gt_e_$lte();
    }
    
    
    
    
    
    public static void procurarTodasAsPessoas(){
        DBCursor cursor = PESSOAS.find();
        try{
            while(cursor.hasNext())
                System.out.println(cursor.next().toString());
        }finally{
            cursor.close();
        }
    }
    
    /* 
     ***********************************************************************************************************
     ***********************************************************************************************************
    */
    
    public static void pegarABernardete(){
        BasicDBObject bernardete = new BasicDBObject("nome", "Bernardete Topa Tudo");
        DBCursor cursor = PESSOAS.find(bernardete);
        
        try{
            while(cursor.hasNext())
                System.out.println(cursor.next().toString());
        }finally{
            cursor.close();
        }
    } 
    
    /* 
     ***********************************************************************************************************
     ***********************************************************************************************************
    */
    
    public static void pegaOsRicosCom$gt(){
        //Os operadores com $ representam chaves de String regulares
        //$gt seleciona os documentos onde o valor é maior do que o valor especificado
        BasicDBObject query = new BasicDBObject("salario", new BasicDBObject("$gt", 501.45));
        DBCursor cursor = PESSOAS.find(query);
        
        try{
            while(cursor.hasNext())
                System.out.println(cursor.next().toString());
        }finally{
            cursor.close();
        }
    }
    
    /* 
     ***********************************************************************************************************
     ***********************************************************************************************************
    */
    
    public static void pega_pessoas_com_$gt_e_$lte(){
        BasicDBObject query = new BasicDBObject("salario", new BasicDBObject("$gt",503.23).append("$lte", 743.2));
        DBCursor cursor = PESSOAS.find(query);
        
        try{
            while(cursor.hasNext())
                System.out.println(cursor.next().toString());
        }finally{
            cursor.close();
        }
    }
    
    

}
