package com.santanatextiles.cpf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santanatextiles.cpf.domain.Fornecedor;
import com.santanatextiles.cpf.domain.FornecedorId;
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, FornecedorId>{
	
	   @Query(value =  
	      "Select IDFIL,B2COD ,B2NOME,B2TIPO ,B2CGCCPF,B2TPENTIDA   " +
	      " from ccp.ccpb2_dbf b2 " +
	      " where b2.idfil =  STL.FN_STL_IDFIL('CCPB2',?1)",nativeQuery = true)
	    List<Fornecedor> buscaFornecedor(String filial) ; 
	     
	    @Query(value =  
	      "Select IDFIL,B2COD ,B2NOME,B2TIPO ,B2CGCCPF,B2TPENTIDA   " +
	      " from ccp.ccpb2_dbf b2 " +
	      " where b2.idfil =  STL.FN_STL_IDFIL('CCPB2',?1)",nativeQuery = true)
	    Page<Fornecedor> buscaFornecedorPag(PageRequest pageRequest, @Param("idfil") String idfil) ;    	
	
	

}
