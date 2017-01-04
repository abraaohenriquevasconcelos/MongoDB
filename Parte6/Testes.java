
package br.inpe.lac;

import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


public class Testes {
    public static void main(String[] args){
        Mongo mongo = new Mongo();
        
        List<Document> cursos = new ArrayList();
        cursos.add(new Document().append("nome", "capoeira").append("tipo", "porrada"));
        cursos.add(new Document().append("nome", "judô").append("tipo", "porrada"));
        Document pedrim = new Document().append("_id", 5).append("nome", "Pedrim doido").append("salario", 436.34)
                                        .append("endereço", new Document().append("rua", "Rua do Beco 15")
                                            .append("bairro", "oliveiras e laranjeiras").append("numero", 45))
                                        .append("cursos", cursos);
        //mongo.adicionarPessoa(pedrim);
        
        /* 
         ***********************************************************************************************************
         ***********************************************************************************************************
        */
        
        FindIterable<Document> resultado = mongo.procurarPeloNome("Pedrim doido");
        
        for(Document document : resultado){
            System.out.println("Nome: "+document.getString("nome"));
            System.out.println("Cursos: "+document.get("cursos").toString());
        }
    }
    
    
    
}
