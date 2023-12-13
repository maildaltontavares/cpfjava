package com.santanatextiles.cpf.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.santanatextiles.cpf.dto.TurnoDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class GenericoRepository {
	
	
   private final EntityManager em;
	
   public GenericoRepository(EntityManager em) {	 
		this.em = em;
	} 	
   
   
	public List<TurnoDTO> buscaHorariosTurnos(String filial) {   
		
		 String cSql =
		"Select k1A.idfil,k1A.k1hsini nHINITA,k1A.k1hsfim nHFIMTA, " +
	    " k1B.k1hsini nHINITB,k1B.k1hsfim nHFIMTB, " +
	    " k1C.k1hsini nHINITC,k1C.k1hsfim nHFIMTC "  +
	    " from  " +
	    " prd.prdk1_dbf k1A " +
	    " inner join prd.prdk1_dbf k1B on k1A.idfil = k1B.idfil and k1B.k1cdturn ='B' " +
	    " inner join prd.prdk1_dbf k1C on k1A.idfil = k1C.idfil and k1C.k1cdturn ='C' " +
	    " where k1A.idfil = '" + filial + "' and k1A.k1cdturn ='A'    "	 +
	    " Union all  " +	
		 
		 
		 "Select '02' idfil,k1A.k1hsini nHINITA,k1A.k1hsfim nHFIMTA, " +
		    " k1B.k1hsini nHINITB,k1B.k1hsfim nHFIMTB, " +
		    " k1C.k1hsini nHINITC,k1C.k1hsfim nHFIMTC "  +
		    " from  " +
		    " prd.prdk1_dbf k1A " +
		    " inner join prd.prdk1_dbf k1B on k1A.idfil = k1B.idfil and k1B.k1cdturn ='B' " +
		    " inner join prd.prdk1_dbf k1C on k1A.idfil = k1C.idfil and k1C.k1cdturn ='C' " +
		    " where k1A.idfil = '" + filial + "' and k1A.k1cdturn ='A'    "	 +
		 
	    " Union all  " +	   
		 
		 "Select  '03'  idfil,k1A.k1hsini nHINITA,k1A.k1hsfim nHFIMTA, " +
		    " k1B.k1hsini nHINITB,k1B.k1hsfim nHFIMTB, " +
		    " k1C.k1hsini nHINITC,k1C.k1hsfim nHFIMTC "  +
		    " from  " +
		    " prd.prdk1_dbf k1A " +
		    " inner join prd.prdk1_dbf k1B on k1A.idfil = k1B.idfil and k1B.k1cdturn ='B' " +
		    " inner join prd.prdk1_dbf k1C on k1A.idfil = k1C.idfil and k1C.k1cdturn ='C' " +
		    " where k1A.idfil = '" + filial + "' and k1A.k1cdturn ='A'    "	;		 
		
		var q = em.createNativeQuery(cSql);		
		var cTurno =  q.getResultList();    
		
		
		TypedQuery<TurnoDTO> qr = 
		        em.createQuery(cSql, TurnoDTO.class);

		List<TurnoDTO> listOfSimpleEntities = q.getResultList();
		for (TurnoDTO entity : listOfSimpleEntities) {
		    // do something useful with entity;
		}		
		
		
	    
		//TurnoDTO t = new TurnoDTO("01",1,2,3,4,5,0);
		
		
	    //String pFil = String.valueOf(cFilial.get(0)); 
	    //String s = pFil ;  
		
		//TurnoDTO t1 = (TurnoDTO) cTurno.get(0);
		
	    //System.out.println(t.getnHFIMTA());
	    //System.out.println(t.getnHFIMTB());
		
	   //List<TurnoDTO> t1 =  (List<TurnoDTO>)(Object)q.getResultList() ;
		
		List<TurnoDTO> t1 =  (List<TurnoDTO>)(Object)q.getResultList() ;
		
		
	    
//	    for (TurnoDTO entity : t1) {


	//	    System.out.println(entity.getnHFIMTA());
		//    System.out.println(entity.getnHFIMTB());
		   
	//    }
	    
	    //System.out.println(t1.get(0).getnHFIMTA());
	    //System.out.println(t1.get(0).getnHFIMTB());
	    
	     
		return  t1 ; 
		
	}   
	
	
	
	
	
	
	
	

}
