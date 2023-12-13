package com.santanatextiles.cpf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.cpf.domain.Operador;
import com.santanatextiles.cpf.domain.OperadorId;

@Repository 
public interface OperadorRepository extends JpaRepository<Operador,OperadorId>   { 
	
    @Transactional(readOnly=true)
    List<Operador> findByIdfilAndNome(String idfil,String nome) ; 
    
 
	Operador findByIdfilAndCodigo(String idfil,String codigo);    
	
	Long deleteByIdfilAndCodigo(String idfil,String codigo);  
	
		
	
    @Query(value = "Select 	 E5CDOPER,"
    		+ "E5NOMEOP,"
    		+ "E5TIPMAQ,"
    		+ "E5CDTURN,"
    		+ "E5HSDISP,"
    		+ "E5FOLG,"
    		+ "E5SENHA,"
    		+ "IDFIL,"
    		+ "E5GPCMT" +
    	      " from prd.prde5_dbf e5 "+
    	      " where e5.idfil =  STL.FN_STL_IDFIL('PRDE5',?1) and trim(E5NOMEOP) like %?2% order by E5NOMEOP",nativeQuery = true)
      List<Operador> buscaOperadorPorNome(@Param("idfil") String idfil, @Param("nome") String nome) ; 	  	
	
	
	

}
