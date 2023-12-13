package com.santanatextiles.cpf.repositories;

//import java.io.Console;
//import java.util.List;

import org.springframework.stereotype.Repository; 
import jakarta.persistence.EntityManager;

@Repository
public class IdfilRepository {
	
	private final EntityManager em;
	
	public IdfilRepository(EntityManager em) {	 
		this.em = em;
	} 
	
	public String buscaFilial(String tabela,String filial) {  
		 
		String cSql = "Select  STL.FN_STL_IDFIL('" + tabela +  "','" + filial + "') emp from dual";  
		
		var q = em.createNativeQuery(cSql);		
		var cFilial =  q.getResultList() ;    
	    
	    String pFil = String.valueOf(cFilial.get(0)); 
	    String s = pFil ;  
	    
	    // System.out.print(s);
	    em.close(); 
		return  s; 
		
	}

	 
	
	

}
