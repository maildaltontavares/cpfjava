package com.santanatextiles.cpf.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.cpf.customQueryResults.UltProdFiacao;
import com.santanatextiles.cpf.domain.ProducaoFiacao;
import com.santanatextiles.cpf.domain.Turno;
import com.santanatextiles.cpf.dto.ProducaoFiacaoDTO;
import com.santanatextiles.cpf.repositories.ProducaoFiacaoRepository;
import com.santanatextiles.cpf.resources.exception.DataIntegrityException;

@Service	
public class ProducaoFiacaoService {
	
	@Autowired
	private ProducaoFiacaoRepository repo;
	
    @Autowired
	private UltProdFiacaoService ultProdServ;
    
    @Autowired
	private TurnoService turnoProd;
	
	private ArrayList<String> msg = new ArrayList<>(); 	
	private ArrayList<String> msgVldData = new ArrayList<>();
 
	@Value("${spring.datasource.url}")
	private String JDBC_URL;
	
	@Value("${spring.datasource.username}")
	private String JDBC_USER;

	@Value("${spring.datasource.password}")
	private String JDBC_PASSWORD;	
	
	 
	
    public Page<ProducaoFiacao> buscaProducaoFiacaoPag(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);    
		return repo.buscaProducaoFiacaoPag(pageRequest, idfil);
	    }	
    
    
	public List<ProducaoFiacao> pesquisaProducaoFiacaoByParam(String idfil,String maquina,String dataInicial,String dataFinal,String tmMaquina,String turno){	 
		List<ProducaoFiacao> obj = repo.pesquisaProducaoFiacaoByParam(idfil,maquina,dataInicial,dataFinal, tmMaquina,turno); 
		return  obj;							 
	}    

	
	public ProducaoFiacao buscaProducaoFiacaoByPK(String idfil , String maquina, String dataProd, String turno, String lado, Integer horaIni){	 
		ProducaoFiacao obj = repo.buscaProducaoFiacaoByPK( idfil , maquina, dataProd, turno, lado,  horaIni );
		return  obj;							 
	}      
	
	
	public List<ProducaoFiacao> buscaProducaoFiacao(String idfil){	 
		List<ProducaoFiacao> obj = repo.buscaProducaoFiacao(idfil); 
		return  obj;							 
	}   

	public List<Map<String, Object>> buscaDadosCalcEfic(String idfil, String item, Integer horaInicio, Integer horaFim){	 
		List<Map<String, Object>> obj = repo.buscaDadosCalcEfic(idfil, item, horaInicio, horaFim);  
		
		return  obj;							 
	}  	
	
	
	public List<Map<String, Object>> numApontamentos  (String idfil , String maquina, String dataProd, String turno, String lado ){	 
		List<Map<String, Object>> obj = repo.numApontamentos(idfil, maquina,  dataProd, turno, lado );  		
		return  obj;							 
	}  	 
	
	@Transactional
	public ProducaoFiacao insert(ProducaoFiacao obj) {	 
		
 
		if(!obj.getCodigoMaquina().equals("11")) {			
			obj.setIdSSM(9999999);
		}		
		
		verificaEntidades(obj); 
		
		if (!this.msg.isEmpty()) {					 
			throw new DataIntegrityException(String.join(",", this.msg)); } 	
		
		return repo.save(obj);			
	} 		
	
	
	@Transactional
	public ProducaoFiacao update(ProducaoFiacao obj) {	 
		
		if(!obj.getCodigoMaquina().equals("11")) {			
			obj.setIdSSM(9999999);
		}		
 
		verificaEntidades(obj);
		
		if (!this.msg.isEmpty()) {					 
			throw new DataIntegrityException(String.join(",", this.msg)); } 	 
		
		return repo.save(obj);	
		
	} 	
	
	@Transactional
	public Boolean  deletaProducaoFiacao(String idfil, String maquina, String dataProducao, String turno, String lado, Integer horaInicial) throws SQLException {
 	 
		
		try {
			
			Connection myConnection=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
	
	        Statement sqlStatement = myConnection.createStatement();
	        String deleteRecordSQL = "" +
	                "Delete from cpf.cpfd4_dbf d4 where idfil = '" + idfil + "' and d4cod = '" + maquina + "' and " + 
	                " to_char(d4.d4data,'yyyymmdd') = '" + dataProducao + "' and " +
	                " d4turno = '" + turno + "' and " +
	                " d4lado =  '" + lado  + "' and " +
	                " D4HRINI = " + horaInicial
	    			 ;		
 
	        int linhasAfetadas = sqlStatement.executeUpdate(deleteRecordSQL); 
	        
	        System.out.println("Linhas afetadas: " + linhasAfetadas); 
   
	        sqlStatement.close();
	        myConnection.close();	        
	        
	        	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return true;
		
	}	
	 
	
	public List<String> validaData(ProducaoFiacaoDTO obj) {	  
	 
		List<String> retorno = validaDatas(obj); 
		return retorno;	  
		
	} 		
		
	
	public List<String> validaDatas(ProducaoFiacaoDTO obj) {
		this.msgVldData.clear();		
		try {
		
				if(obj.getDataProducao() != null) {	 
					
					UltProdFiacao ultProdF = ultProdServ.pesquisaUltimaProducao(obj.getIdfil(), obj.getCodigoMaquina(), obj.getLado()); 
					
					if(ultProdF == null) { 
			    		this.msgVldData.add("1");
			    		this.msgVldData.add("Nao há registro para a maquina " +obj.getCodigoMaquina()+ "/" + obj.getLado());    
			    	    return this.msgVldData;		 
					}
		
					String St = obj.getDataProducao().toString(); 
					DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.US); 
					LocalDate dtProdWeb =  LocalDate.parse(St, format); 
					
					St = ultProdF.getDataProducao().toString(); 
					format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.US); 
					LocalDate dtUlProd =  LocalDate.parse(St, format);	 
					 
					 
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
			        String dtUltProdFormatada = dtUlProd.format(formatter);					
					
					
					
					//String dtPadraoFormatada = dtUlProd.getDayOfMonth() + '/' +  dtUlProd.getDayOfMonth()  + '/' + dtUlProd.getYear(); 
					
				    long diferencaEmDias = ChronoUnit.DAYS.between(dtUlProd, dtProdWeb);   
				    
			    	// Se ultimo registro informado é anterior a 2 dias da atual data informada.
			    	// Verifica se informou o dia completo ate o final do turno C.
			    	// Solicita confirmacao se dia estiver completeto
			    	
			    	if( diferencaEmDias >1) {	 
			    		
			    		// Hora da ultima producao deve ser igual a hora final do turno C			    		
			    		if(!ultProdF.getHoraFinal().equals(ultProdF.getHoraFinalTurnoC())) {
 			    			this.msgVldData.add("2");
				    		this.msgVldData.add("Complete os registros do dia " + dtUltProdFormatada   );  //  dtUlProd.getDayOfMonth() + '/' +  dtUlProd.getDayOfMonth()  + '/' + dtUlProd.getYear()
				    		
				    		
				    		return this.msgVldData;	
			    		}		
				    	else {
				    		// Apontamento com data posterior a ultima data ja apontada 
				    		this.msgVldData.add("3");
				    		this.msgVldData.add(dtUlProd.toString());
				    		return this.msgVldData;	
				    			
				    	} 
			    		
			    	}	else if( diferencaEmDias < 0) {	 
			    		
			    		// Apontamento com data anterior a ultima data ja apontada 
			    		this.msgVldData.add("5");
			    		this.msgVldData.add(dtUlProd.toString());
			    		return this.msgVldData;		 
			       
			    	// Data é o dia seguinte ao apontaemnto		
			    	}else if( diferencaEmDias == 1) { 
			    		
			    		 if(!(ultProdF.getTurno().equals("C"))) { 
	 			    			this.msgVldData.add("2");
					    		this.msgVldData.add("Complete os registros do dia " + dtUltProdFormatada );  
					    		return this.msgVldData;		 
			    		 }
			    		 
			    		 /*
			    		// Valida se o turno apontado é o correto.	
			    		  if(ultProdF.getTurno().equals("A")) { 
			    			   
			    	    		   // VErifica se turno A ja foi encerrado.		    		
			    	    		   if(!ultProdF.getHoraFinal().equals(ultProdF.getHoraFinalTurnoA())) {
			    	    			   
			    	    			   //Se turno A nao foi encerrado, exige que turno atual seja o turno A
			    	    			   if(!obj.getTurno().equals("A")) { 
								    		this.msgVldData.add("10");
								    		this.msgVldData.add("Turno informado deve ser o turno A.");
								    		return this.msgVldData;		 
			    	    			   }
			    	    			   
			    	    		   }else {
			    	    			   
			    	    			   if( !obj.getTurno().equals("B") ) { 
								    		this.msgVldData.add("11");
								    		this.msgVldData.add("Turno informado deve ser o turno B.");
								    		return this.msgVldData;		 
			    	    			   }			    	    			   
			    	    			   
			    	    		   }  
			    		  }		
			    				
			    		   
			    		  if(ultProdF.getTurno().equals("B")) { 
			    			   
		    	    		   // VErifica se turno A ja foi encerrado.		    		
		    	    		   if(!ultProdF.getHoraFinal().equals(ultProdF.getHoraFinalTurnoB())) {
		    	    			   
		    	    			   //Se turno A nao foi encerrado, exige que turno atual seja o turno B
		    	    			   if(!obj.getTurno().equals("B")) {

							    		this.msgVldData.add("10");
							    		this.msgVldData.add("Turno informado deve ser o turno B.");
							    		return this.msgVldData;	 
		    	    			   }
		    	    			   
		    	    		   }else {
		    	    			   
		    	    			   if( !obj.getTurno().equals("C") ) {

							    		this.msgVldData.add("11");
							    		this.msgVldData.add("Turno informado deve ser o turno C.");
							    		return this.msgVldData;		
		    	    				   
		    	    			   }			    	    			   
		    	    			   
		    	    		   } 	 
		    			   
		    		      }	  
		    		      */
			    		  
			    		  if(ultProdF.getTurno().equals("C")) { 
			    			   
		    	    		   // VErifica se turno A ja foi encerrado.		    		
		    	    		   if(!ultProdF.getHoraFinal().equals(ultProdF.getHoraFinalTurnoC())) {
		    	    			   
		    	    			   //Se turno A nao foi encerrado, exige que turno atual seja o turno C
		    	    			   if(!obj.getTurno().equals("C")) {

							    		this.msgVldData.add("10");
							    		this.msgVldData.add("Turno informado deve ser o turno C.");
							    		return this.msgVldData;		
		    	    				   
		    	    			   }
		    	    			   
		    	    		   }else {
		    	    			   
		    	    			   if( !obj.getTurno().equals("A") ) {

							    		this.msgVldData.add("11");
							    		this.msgVldData.add("Turno informado deve ser o turno A.");
							    		return this.msgVldData;		
		    	    				   
		    	    			   }			    	    			   
		    	    			   
		    	    		   } 
		    			   
		    		      }	  
			    	}else if( diferencaEmDias == 0) { 
			    		
			    		
			    		// Valida se o turno apontado é o correto.	
			    		  if(ultProdF.getTurno().equals("A")) { 
			    			   
			    	    		   // VErifica se turno A ja foi encerrado.		    		
			    	    		   if(!ultProdF.getHoraFinal().equals(ultProdF.getHoraFinalTurnoA())) {
			    	    			   
			    	    			   //Se turno A nao foi encerrado, exige que turno atual seja o turno A
			    	    			   if(!obj.getTurno().equals("A")) { 
								    		this.msgVldData.add("10");
								    		this.msgVldData.add("Turno informado deve ser o turno A.");
								    		return this.msgVldData;		 
			    	    			   }
			    	    			   
			    	    		   }else {
			    	    			   
			    	    			   if( !obj.getTurno().equals("B") ) { 
								    		this.msgVldData.add("11");
								    		this.msgVldData.add("Turno informado deve ser o turno B.");
								    		return this.msgVldData;		 
			    	    			   }			    	    			   
			    	    			   
			    	    		   }  
			    		  }		
			    				
			    		   
			    		  if(ultProdF.getTurno().equals("B")) { 
			    			   
		    	    		   // VErifica se turno A ja foi encerrado.		    		
		    	    		   if(!ultProdF.getHoraFinal().equals(ultProdF.getHoraFinalTurnoB())) {
		    	    			   
		    	    			   //Se turno A nao foi encerrado, exige que turno atual seja o turno B
		    	    			   if(!obj.getTurno().equals("B")) {

							    		this.msgVldData.add("10");
							    		this.msgVldData.add("Turno informado deve ser o turno B.");
							    		return this.msgVldData;	 
		    	    			   }
		    	    			   
		    	    		   }else {
		    	    			   
		    	    			   if( !obj.getTurno().equals("C") ) {

							    		this.msgVldData.add("11");
							    		this.msgVldData.add("Turno informado deve ser o turno C.");
							    		return this.msgVldData;		
		    	    				   
		    	    			   }			    	    			   
		    	    			   
		    	    		   } 	 
		    			   
		    		      }	  
		    		       
			    		  
			    		  if(ultProdF.getTurno().equals("C")) { 
			    			   
		    	    		   // VErifica se turno A ja foi encerrado.		    		
		    	    		   if(!ultProdF.getHoraFinal().equals(ultProdF.getHoraFinalTurnoC())) {
		    	    			   
		    	    			   //Se turno A nao foi encerrado, exige que turno atual seja o turno C
		    	    			   if(!obj.getTurno().equals("C")) {

							    		this.msgVldData.add("10");
							    		this.msgVldData.add("Turno informado deve ser o turno C.");
							    		return this.msgVldData;		
		    	    				   
		    	    			   }
		    	    			   
		    	    		   }else {
		    	    			   
		    	    			   if( !obj.getTurno().equals("A") ) {

							    		this.msgVldData.add("11");
							    		this.msgVldData.add("Turno informado deve ser o turno A.");
							    		return this.msgVldData;		
		    	    				   
		    	    			   }			    	    			   
		    	    			   
		    	    		   } 
		    			   
		    		      }	 
			    		
			    	}
			    	
			    	// Verifica se a hora inicial nao for igual a hora final do ultimo apontamento
			    	if(!obj.getHoraInicio().equals(ultProdF.getHoraFinal())) {
			    		
			    		this.msgVldData.add("6");
			    		this.msgVldData.add("Hora Inicial deve ser " + ultProdF.getHoraFinal().toString().substring(0, 2) + ":" + ultProdF.getHoraFinal().toString().substring(2,4)   ); 
			    		
			    		return this.msgVldData;					    		
			    		
			    	}  
			    	
				}	   
		
		}		
		catch (Exception e) {	
			
			this.msgVldData.add(e.getMessage());
		}
		this.msgVldData.add("OK");
		this.msgVldData.add("OK");	
		return this.msgVldData;	
		
		
	}
	
	 
	 private void verificaEntidades(ProducaoFiacao obj) {			 
		 this.msg.clear();
			try {
				
				 if(obj.getIdfil() == null) {
				 	this.msg.add("Filial não informada");
			     }  
				
		    	 // Valida se as horas sao iguais
		     	 if( obj.getHoraInicio().equals(obj.getHoraFinal()))  {
		    		  this.msg.add("Hora inicial igual a data final.");  	
		    		  return; 
		    	 }				
				
				 Turno turnoProducao = turnoProd.buscaTurnoById(obj.getIdfil(), obj.getTurno()); 
				
				 if(!(obj.getTurno().equals("C"))) {
					 
				    	// Valida se a hora inicial encontra-se dentro do turno
				    	if(obj.getHoraInicio() < turnoProducao.getHoraInicial() || obj.getHoraInicio() > turnoProducao.getHoraFinal() ) {
				    		this.msg.add("Hora inicial fora do turno " + obj.getTurno());  	
				    		return;
				    		
				    	}
				    	
				    	// Valida se a hora final encontra-se dentro do turno
				    	if(obj.getHoraFinal() < turnoProducao.getHoraInicial() || obj.getHoraFinal() > turnoProducao.getHoraFinal() ) {
				    		this.msg.add("Hora final fora do turno " + obj.getTurno());  	
				    		return;
				    		
				    	}	 
				    	
				    	// Valida se a hora inicial é menor que a data final
				    	if(obj.getHoraInicio() > obj.getHoraFinal())  {
				    		this.msg.add("Hora inicial deve ser menor que data final.");  	
				    		return;
				    		
				    	}	
				    	

				 } else { 

				    	//Hora inicial na primeira etapa
				    	if(obj.getHoraInicio() < 2400  &&  obj.getHoraInicio() >= turnoProducao.getHoraInicial() ) {  
				    		
				    		// Hora Final na primeira etapa
				    		if( obj.getHoraFinal() < 2400 && obj.getHoraFinal() >= turnoProducao.getHoraInicial() ) { 
				    			
					    		if(obj.getHoraInicio() >= obj.getHoraFinal()) {
						    		this.msg.add("Hora inicial deve ser menor que data final.");  	
						    		return; 
						       	} 	  
				    		} else {
				    			// Hora Final na segunda etapa
				    			if(!(obj.getHoraFinal() <= turnoProducao.getHoraFinal() )) {				    				
					    			this.msg.add("Hora final fora do turno " + obj.getTurno());  	
						    		return; 				    								    				
				    			} 
				    		}
					    		
					    // Hora inicial na 2a etapa 		
				    	}else { 
				    		
				    		if( !(obj.getHoraInicio() < turnoProducao.getHoraFinal()  ) ) {				    		
				    			this.msg.add("Hora inicial fora do turno " + obj.getTurno());  	
					    		return; 
				    	     }else {
				    	    	 
					    			// Hora Final na segunda etapa
					    			if(!(obj.getHoraFinal() <= turnoProducao.getHoraFinal() )) {				    				
						    			this.msg.add("Hora final fora do turno " + obj.getTurno());  	
							    		return; 				    								    				
					    			} 
					    			
						    		if(obj.getHoraInicio() >= obj.getHoraFinal()) {
							    		this.msg.add("Hora inicial deve ser menor que data final.");  	
							    		return; 
							       	} 	 
				    	    	 
				    	     }
				    		
				         } 	 
					 
				 } 
				 
			}			
			catch (Exception e) {	
				this.msg.add(e.getMessage());
			}
			return; 			 
	 }	
	 
	 
  
	 
 
 /*
		@Transactional
		public void deletaProducaoFiacao(String idfil,String codigoMaquina,String turno,Date dataProducao,String lado,Integer horaInicio){
			try {			  
				 repo.deletaProducaoFiacao(idfil, codigoMaquina, turno, dataProducao, lado, horaInicio);
			}
			catch (DataIntegrityViolationException e) {
				throw new ObjectNotFoundException("Erro de Violação de Integridade");
			}
		}	 
 */
}
