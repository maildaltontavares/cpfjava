package com.santanatextiles.cpf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.cpf.domain.Maquina;
import com.santanatextiles.cpf.domain.MaquinaId;

 

@Repository 
public interface MaquinaRepository extends JpaRepository<Maquina, MaquinaId>   {  

	
    @Query(value = "Select 	IDFIL,C3COD,C3DESC,C3EMP,C3NUMFUS,C3RPM,C3CDABER,C3NUMSER,C3LOCAL,C3MQSSM,C3LADO,C3TIT,C3HRDIA " +
    	      " from cpf.cpfc3_dbf c3 "+
    	      " where c3.idfil =  STL.FN_STL_IDFIL('CPFC3',?1)  order by substr(C3COD,3,2),C3LOCAL",nativeQuery = true)
    List<Maquina> buscaMaquina(String filial) ;   
    
    @Query(value = "Select 	IDFIL,C3COD,C3DESC,C3EMP,C3NUMFUS,C3RPM,C3CDABER,C3NUMSER,C3LOCAL,C3MQSSM,C3LADO,C3TIT,C3HRDIA " +
  	      " from cpf.cpfc3_dbf c3 "+
  	      " where c3.idfil =  STL.FN_STL_IDFIL('CPFC3',?1) and trim(C3DESC) like %?2% order by substr(C3COD,3,2),C3LOCAL",nativeQuery = true)
    List<Maquina> buscaMaquinaPorNome(@Param("idfil") String idfil, @Param("nome") String nome) ; 	  
    
	
    @Query(value = "Select 	IDFIL,C3COD,C3DESC,C3EMP,C3NUMFUS,C3RPM,C3CDABER,C3NUMSER,C3LOCAL,C3MQSSM,C3LADO,C3TIT,C3HRDIA " +
  	      " from cpf.cpfc3_dbf c3 "+
  	      " where c3.idfil =  STL.FN_STL_IDFIL('CPFC3',?1)",nativeQuery = true)
     Page<Maquina> buscaMaquinaPag(PageRequest pageRequest, @Param("idfil") String idfil) ;   	    
    
    @Transactional(readOnly=true)
    List<Maquina> findByNomeContains(String nome) ; 
    
	@Transactional
	Long deleteByIdfilAndCodigo(String idfil,String codigo);    
	
	
    @Query(value = "Select 	IDFIL,C3COD,C3DESC,C3EMP,C3NUMFUS,C3RPM,C3CDABER,C3NUMSER,C3LOCAL,C3MQSSM,C3LADO,C3TIT,C3HRDIA " +
  	      " from cpf.cpfc3_dbf c3 "+
  	      " where c3.idfil =  STL.FN_STL_IDFIL('CPFC3',?1) and c3local = ?2 and substr(c3cod,3,2) = ?3",nativeQuery = true)
  Maquina buscaMaquinaPorLocal(String filial, String Local,String tiopoMaquina) ;   	
	
	

}
