package com.santanatextiles.cpf.repositoriesCustomQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.santanatextiles.cpf.customQueryResults.UltProdFiacao;
import com.santanatextiles.cpf.customQueryResults.UltProdFiacaoId;

public interface UltProdFiacaoRepository extends JpaRepository<UltProdFiacao, UltProdFiacaoId> {
	
	
	@Query(value =  
			
			"Select  idfil, d4cod,d4data,d4hrfim , d4turno   , d4lado  , nHINITA, nHFIMTA,  nHINITB, nHFIMTB,  nHINITC, nHFIMTC " + 
			"from " + 
			"(    " +
			"        select  d4.idfil,d4.d4cod,d4data,d4hrfim , d4turno   , d4lado  , nHINITA, nHFIMTA,  nHINITB, nHFIMTB,  nHINITC, nHFIMTC   , " +
			"        case  " +
			"           when d4hrfim <=  nHFIMTC  then '2' " +
			"           else '1'   " +
			"        end ordem     " +
			"        from cpf.cpfd4_dbf d4 " +
			"        inner join cpf.v_cpf_w_horarios_turnos vt on d4.idfil = vt.idfil " + 
			"        where d4.idfil  = :idfil     " +     
			"        and   d4cod     = :maquina   " + 
			"        and  (d4.idfil || d4cod || d4lado || to_char(d4data,'yyyymmdd')  )   in " +        
			"        ( " +
			"                select  ( d4.idfil || d4cod ||  d4lado || max(to_char(d4data,'yyyymmdd') )  )  chave " +   
			"                from   cpf.cpfd4_dbf d4     " + 
			"                where d4.idfil = :idfil     " + 
			"                and   d4cod    = :maquina   " + 
			"                and   d4lado   = :lado      " +
			"                and   to_char(d4data,'yyyymm') >= to_char(sysdate-200,'yyyymm')  " + 
			"                and   to_char(d4data,'yyyymm') <= to_char(sysdate,'yyyymm') " +    
			"                and d4hrfim is not null " + 
			"                group by  d4.idfil,d4cod ,d4lado " +  
			"        )  " +
			"        order by d4.idfil,d4.d4cod,ordem desc, d4hrfim desc " +  
			") " + 
		    " where rownum = 1 "	 
		      ,nativeQuery = true)		
		   UltProdFiacao  pesquisaUltimaProducao(
				@Param("idfil") String idfil ,
				@Param("maquina") String maquina,
				@Param("lado") String lado
				);	
				
	
	 

}
