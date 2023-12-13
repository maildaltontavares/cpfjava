package com.santanatextiles.cpf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santanatextiles.cpf.domain.FichaTecnica;
import com.santanatextiles.cpf.domain.FichaTecnicaId;

@Repository
public interface FichaTecnicaRepository  extends JpaRepository<FichaTecnica,FichaTecnicaId>{
	
	
    @Query(value = 
    	      "Select idfil,h8cod,h8tit,h8tpmaq   " +
    	      " from cpf.cpfh8_dbf h8  " +
    	      " where h8.idfil =  :idfil and h8cod = :item",nativeQuery = true)
    FichaTecnica  buscaFichaTecnicaItem(String idfil, String item) ; 	
	
	

}
