package com.santanatextiles.cpf.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santanatextiles.cpf.domain.ProducaoFiacao;
import com.santanatextiles.cpf.domain.ProducaoFiacaoId;

import jakarta.persistence.NamedStoredProcedureQueries;

@Repository
public interface ProducaoFiacaoRepository extends JpaRepository<ProducaoFiacao, ProducaoFiacaoId> {
	
	
	@Query(value = 
	        "Select     " +
	        "IDFIL,	    " + 
	    	"D4COD ,    " +
	    	"D4DATA ,   " +
	        "D4TURNO ,  " +
			"D4HRINI,   " +
			"D4LADO,	" +  
			"D4HRFIM,   " +
			"D4ITEM,    " +
			"D4PROD,    " +
			"D4EFIC,	" +
			"D4KGHR,	" +
			"C4CDABER,	" +
			"D4LOTE,	" + 
			"D4TITULO, 	" +	
	         "D4FORPOLIE," +
			"D4FORELAST," +
			"D4LOTEPOLI," +
			"D4LOTEELAS," +
			"D4COR,		" +
			"D4VELOC,	" +
			"D4NUMFUS,	" +
			"D4NUMRUP,	" +
			"D4METR,	" +
			"D4ID,		" +
			"D4NUMTRC,	" +
			"D4TRCFIO,	" +
			"D4HRTRFI,	" +
			"D4HRTRFF,  " +
			"D4NMFORE,	" +
			"D4NMFORP,	" +
			"D4NUMSER,	" +
			"D4LOCAL,	" +
			"D4REPR,	" +
			"D4OBS,		" +
			"D4ALFA,	" +
			"D4TPM,		" +			
			"D4TIT,		" +
			"D4OPER,	" +
			"D4RPMCAR,	" +
			"D4PTON,	" +
			"D4PTOS,	" +
			"D4PTOL,	" +
			"D4PTOF,	" +
			"D4MO,		" +
			"D4CPVSL,	" +
			"D4CMVSL,	" +
			"D4CCPC,	" +
			"D4CCMC,	" +
			"D4JP,		" +
			"D4JM,		" +
			"D4CVP,		" +
			"D4CVM,		" +
			"D4PROB1,	" +
			"D4PROB2,	" +
			"D4PROB3,	" +
			"D4TBOB,	" +
			"D4CNAT,        " +
			"D4PRDTUR,      " +
			"D4TITFT     ,   " +	    
		    "D4ESTIRG,  " +  
		    "D4QTFITA,  " +  
		    "D4D,       " +       
		    "D4CV,      " +      
		    "D4CVIN,    " +    
		    "D4PG,      " +      
		    "D4A  ,     " +     
		    "D4T25,     " +     
		    "D4T20,     " +     
		    "D4T15 ,    " +    
		    "D4T125,    " +    
		    "D4T120,    " +    
		    "D4T115,    " +    
		    "D4T225,    " +    
		    "D4T220,    " +    
		    "D4T215 "  +  	  
	      " from cpf.cpfd4_dbf d4 " +
	      " where d4.idfil = :idfil and D4DATA is not null and D4COD is not null and d4hrini is not null",nativeQuery = true)
	   Page<ProducaoFiacao> buscaProducaoFiacaoPag(PageRequest pageRequest, @Param("idfil") String idfil) ; 	
	 
	
	
	@Query(value = 
	        "Select     " +
	        "IDFIL,	    " + 
	    	"D4COD ,    " +
	    	"D4DATA ,   " +
	        "D4TURNO ,  " +
			"D4HRINI,   " +
			"D4LADO,	" +  
			"D4HRFIM,   " +
			"D4ITEM,    " +
			"D4PROD,    " +
			"D4EFIC,	" +
			"D4KGHR,	" +
			"C4CDABER,	" +
			"D4LOTE,	" + 
			"D4TITULO, 	" +	
	        "D4FORPOLIE," +
			"D4FORELAST," +
			"D4LOTEPOLI," +
			"D4LOTEELAS," +
			"D4COR,		" +
			"D4VELOC,	" +
			"D4NUMFUS,	" +
			"D4NUMRUP,	" +
			"D4METR,	" +
			"D4ID,		" +
			"D4NUMTRC,	" +
			"D4TRCFIO,	" +
			"D4HRTRFI,	" +
			"D4HRTRFF,  " +
			"D4NMFORE,	" +
			"D4NMFORP,	" +
			"D4NUMSER,	" +
			"D4LOCAL,	" +
			"D4REPR,	" +
			"D4OBS,		" +
			"D4ALFA,	" +
			"D4TPM,		" +			
			"D4TIT,		" +
			"D4OPER,	" +
			"D4RPMCAR,	" +
			"D4PTON,	" +
			"D4PTOS,	" +
			"D4PTOL,	" +
			"D4PTOF,	" +
			"D4MO,		" +
			"D4CPVSL,	" +
			"D4CMVSL,	" +
			"D4CCPC,	" +
			"D4CCMC,	" +
			"D4JP,		" +
			"D4JM,		" +
			"D4CVP,		" +
			"D4CVM,		" +
			"D4PROB1,	" +
			"D4PROB2,	" +
			"D4PROB3,	" +
			"D4TBOB,	" +
			"D4CNAT,        " +
			"D4PRDTUR,      " +
			"D4TITFT       ,    "  
			+ " D4ESTIRG, "
			+ " D4QTFITA, "
			+ "D4D,       "       
			+ "D4CV,      "      
			+ "D4CVIN,    "    
			+ "D4PG,      "      
			+ "D4A  ,     "     
			+ "D4T25,     "     
			+ "D4T20,     "     
			+ "D4T15 ,    "    
			+ "D4T125,    "    
			+ "D4T120,    "    
			+ "D4T115,    "    
			+ "D4T225,    "    
			+ "D4T220,    "    
			+ "D4T215 "  +  	  
	      " from cpf.cpfd4_dbf d4 " +
	      " where d4.idfil = :idfil and D4DATA is not null and D4COD is not null and d4hrini is not null and and d4local is not null  and rownum < 250" +	   
	      " order by D4DATA desc"
	      ,nativeQuery = true)	
	
	List<ProducaoFiacao> buscaProducaoFiacao(@Param("idfil") String idfil);
	
	
	@Query(value = 
	        "Select     " +
	        "IDFIL,	    " + 
	    	"D4COD ,    " +
	    	"D4DATA ,   " +
	        "D4TURNO ,  " +
			"D4HRINI,   " +
			"D4LADO,	" +  
			"D4HRFIM,   " +
			"D4ITEM,    " +
			"D4PROD,    " +
			"D4EFIC,	" +
			"D4KGHR,	" +
			"C4CDABER,	" +
			"D4LOTE,	" + 
			"D4TITULO, 	" +	
	        "D4FORPOLIE," +
			"D4FORELAST," +
			"D4LOTEPOLI," +
			"D4LOTEELAS," +
			"D4COR,		" +
			"D4VELOC,	" +
			"D4NUMFUS,	" +
			"D4NUMRUP,	" +
			"D4METR,	" +
			"D4ID,		" +
			"D4NUMTRC,	" +
			"D4TRCFIO,	" +
			"D4HRTRFI,	" +
			"D4HRTRFF,  " +
			"D4NMFORE,	" +
			"D4NMFORP,	" +
			"D4NUMSER,	" +
			"D4LOCAL,	" +
			"D4REPR,	" +
			"D4OBS,		" +
			"D4ALFA,	" +
			"D4TPM,		" +			
			"D4TIT,		" +
			"D4OPER,	" +
			"D4RPMCAR,	" +
			"D4PTON,	" +
			"D4PTOS,	" +
			"D4PTOL,	" +
			"D4PTOF,	" +
			"D4MO,		" +
			"D4CPVSL,	" +
			"D4CMVSL,	" +
			"D4CCPC,	" +
			"D4CCMC,	" +
			"D4JP,		" +
			"D4JM,		" +
			"D4CVP,		" +
			"D4CVM,		" +
			"D4PROB1,	" +
			"D4PROB2,	" +
			"D4PROB3,	" +
			"D4TBOB,	" +
			"D4CNAT,    " +
			"D4PRDTUR,  " +
			"D4TITFT,   " + 
		    "D4ESTIRG,  " +  
		    "D4QTFITA,  " +  
		    "D4D,       " +       
		    "D4CV,      " +      
		    "D4CVIN,    " +    
		    "D4PG,      " +      
		    "D4A  ,     " +     
		    "D4T25,     " +     
		    "D4T20,     " +     
		    "D4T15 ,    " +    
		    "D4T125,    " +    
		    "D4T120,    " +    
		    "D4T115,    " +    
		    "D4T225,    " +    
		    "D4T220,    " +    
		    "D4T215 "  +  	      
	      " from cpf.cpfd4_dbf d4 " +
	      " where d4.idfil = :idfil and D4DATA is not null and " + 
	      " D4COD is not null " + 
	      " and d4hrini is not null  and d4local is not null and"    + 
	      " D4COD = :maquina and " +
	      " TO_CHAR(D4DATA,'YYYYMMDD') = :dataProd AND " +
	      " D4TURNO = :turno and " +
	      " D4LADO  = :lado  and  " +	       
	      " D4HRINI  = :horaIni     " 
	      ,nativeQuery = true)		
	 ProducaoFiacao buscaProducaoFiacaoByPK(
			@Param("idfil") String idfil ,
			@Param("maquina") String maquina,
			@Param("dataProd") String dataProd, 
			@Param("turno") String turno,
			@Param("lado") String lado,		 
			@Param("horaIni") Integer horaIni
			 
			);	
	
	
	@Query(value = 
	        "Select     " +
	        "IDFIL,	    " + 
	    	"D4COD ,    " +
	    	"D4DATA ,   " +
	        "D4TURNO ,  " +
			"D4HRINI,   " +
			"D4LADO,	" +  
			"D4HRFIM,   " +
			"D4ITEM,    " +
			"D4PROD,    " +
			"D4EFIC,	" +
			"D4KGHR,	" +
			"C4CDABER,	" +
			"D4LOTE,	" + 
			"D4TITULO, 	" +	
	        "D4FORPOLIE," +
			"D4FORELAST," +
			"D4LOTEPOLI," +
			"D4LOTEELAS," +
			"D4COR,		" +
			"D4VELOC,	" +
			"D4NUMFUS,	" +
			"D4NUMRUP,	" +
			"D4METR,	" +
			"D4ID,		" +
			"D4NUMTRC,	" +
			"D4TRCFIO,	" +
			"D4HRTRFI,	" +
			"D4HRTRFF,  " +
			"D4NMFORE,	" +
			"D4NMFORP,	" +
			"D4NUMSER,	" +
			"D4LOCAL,	" +
			"D4REPR,	" +
			"D4OBS,		" +
			"D4ALFA,	" +
			"D4TPM,		" +			
			"D4TIT,		" +
			"D4OPER,	" +
			"D4RPMCAR,	" +
			"D4PTON,	" +
			"D4PTOS,	" +
			"D4PTOL,	" +
			"D4PTOF,	" +
			"D4MO,		" +
			"D4CPVSL,	" +
			"D4CMVSL,	" +
			"D4CCPC,	" +
			"D4CCMC,	" +
			"D4JP,		" +
			"D4JM,		" +
			"D4CVP,		" +
			"D4CVM,		" +
			"D4PROB1,	" +
			"D4PROB2,	" +
			"D4PROB3,	" +
			"D4TBOB,	" +
			"D4CNAT,        " +
			"D4PRDTUR,      " +
			"D4TITFT ,       " +
		    "D4ESTIRG,  " +  
		    "D4QTFITA,  " +  
		    "D4D,       " +       
		    "D4CV,      " +      
		    "D4CVIN,    " +    
		    "D4PG,      " +      
		    "D4A  ,     " +     
		    "D4T25,     " +     
		    "D4T20,     " +     
		    "D4T15 ,    " +    
		    "D4T125,    " +    
		    "D4T120,    " +    
		    "D4T115,    " +    
		    "D4T225,    " +    
		    "D4T220,    " +    
		    "D4T215 "  +  	  
	      " from cpf.cpfd4_dbf d4 " +
	      " where d4.idfil = :idfil and D4DATA is not null and " + 
	      " D4COD is not null and d4local is not null and " + 
	      " d4hrini is not null  and "    + 
	      "(:maquina IS NULL OR D4COD = :maquina )   and " +
	      "(:tipoMaquina IS NULL OR substr(D4COD,3,2) = :tipoMaquina )   and " +
	      "(:dataProdIni IS NULL OR TO_CHAR(D4DATA,'YYYYMMDD') >= :dataProdIni )   and " +
	      "(:dataProdFim IS NULL OR TO_CHAR(D4DATA,'YYYYMMDD') <= :dataProdFim )   and " + 
	      "(:turno IS NULL OR D4TURNO = :turno ) "+ 
	      " order by D4DATA desc,D4TURNO desc,D4LOCAL"
	      ,nativeQuery = true)		
	List<ProducaoFiacao> pesquisaProducaoFiacaoByParam(
			@Param("idfil") String idfil ,
			@Param("maquina") String maquina,
			@Param("dataProdIni") String dataProdIni,
			@Param("dataProdFim") String dataProdFim,
			@Param("tipoMaquina") String tipoMaquina,
			@Param("turno") String turno 
			 
			 
			);		
	
	
	
	@Query(value = ""+
	" select  cod_inteligente  ,  id_material,  cdClasse , " + 
	" SUBSTR(TB_TP,1,5) as titulo  ,PRD.F_PRD_CALC_TMP_HORAS(:horaInicio,:horaFim) tmp_horas  " +
	" 	from " +
	" (	 " +
	" 	  select D0421_ID_MAT_SAP cod_inteligente  ,m.d0421_id_material id_material, m.D0403_ID_CLASSE_MATERIAL cdClasse  " +  
	"      from " +
	" 	   stl.e0422_stl_item               i, " + 
	" 	   stl.e0421_stl_material           m  " +  
	"      where          " + 
	"      i.d0421_id_material = m.d0421_id_material and " + 
	"      i.d0422_id_item =  to_number(:item) " + 
    " 	) tb_tmp  " + 
	"   left join SAP.tb_dbf tb on idfil = STL.FN_STL_IDFIL('PD', :idfil )   AND tb_nr = 'TT' and trim(TB_CD) = trim(substr(cod_inteligente,1,3)) " 
  ,nativeQuery = true)		
	List<Map<String, Object>> buscaDadosCalcEfic(
	@Param("idfil") String idfil ,
	@Param("item") String item , 
	@Param("horaInicio") Integer horaInicio ,
	@Param("horaFim") Integer horaFim
	 
	);		
	
	
	@Query(value = ""+
    "Select count(*) numReg" + 	  
    " from cpf.cpfd4_dbf d4 " +
    " where d4.idfil = :idfil and D4DATA is not null and " + 
    " D4COD is not null " + 
    " and d4hrini is not null  and d4local is not null and"    + 
    " D4COD = :maquina and " +
    " TO_CHAR(D4DATA,'YYYYMMDD') = :dataProd AND " +
    " D4TURNO = :turno and " +
    " D4LADO  = :lado     "  +
    " group by  idfil,d4cod,d4data,d4turno,d4lado "
    ,nativeQuery = true)		
	List<Map<String, Object>> numApontamentos (
		@Param("idfil") String idfil ,
		@Param("maquina") String maquina,
		@Param("dataProd") String dataProd, 
		@Param("turno") String turno,
		@Param("lado") String lado 	 
		 
		 
		);	
  
	

	
	
}
