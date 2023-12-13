package com.santanatextiles.cpf.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santanatextiles.cpf.domain.Turno;
import com.santanatextiles.cpf.domain.TurnoId;
 
@Repository
public interface TurnoRepository  extends JpaRepository<Turno, TurnoId> {
	
    @Query(value =  
      "Select IDFIL,K1CDTURN, K1HSINI,K1HSFIM    " +
      " from prd.prdk1_dbf k1 " +
      " where k1.idfil =  STL.FN_STL_IDFIL('PRDK1',?1)",nativeQuery = true)
    List<Turno> buscaTurno(String filial) ; 
     
    @Query(value = 
      "Select IDFIL,K1CDTURN, K1HSINI,K1HSFIM    " +
      " from prd.prdk1_dbf k1 " +
      " where k1.idfil =  STL.FN_STL_IDFIL('PRDK1',?1)",nativeQuery = true)
    Page<Turno> buscaTurnoPag(PageRequest pageRequest, @Param("idfil") String idfil) ;     	
	
 
    
    @Query(value =
    "Select k1A.idfil,k1A.k1hsini nHINITA,k1A.k1hsfim nHFIMTA, " +
    " k1B.k1hsini nHINITB,k1B.k1hsfim nHFIMTB, " +
    " k1C.k1hsini nHINITC,k1C.k1hsfim nHFIMTC "  +
    " from  " +
    " prd.prdk1_dbf k1A " +
    " inner join prd.prdk1_dbf k1B on k1A.idfil = k1B.idfil and k1B.k1cdturn ='B' " +
    " inner join prd.prdk1_dbf k1C on k1A.idfil = k1C.idfil and k1C.k1cdturn ='C' " +
    " where k1A.idfil = ?1 and k1A.k1cdturn ='A'    "  
     ,nativeQuery = true)
     List<Map<String, Object>> buscaHorariosTurno(String filial) ; 
    		
   

}
