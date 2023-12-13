package com.santanatextiles.cpf.resources;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.cpf.domain.ProducaoFiacao;
import com.santanatextiles.cpf.dto.ProducaoFiacaoDTO;
import com.santanatextiles.cpf.services.ProducaoFiacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/producao")  
public class ProducaoFiacaoResource {
	
	@Autowired
	private ProducaoFiacaoService service; 	

	
 	@RequestMapping(value="/filial/{idfil}/paginado",method=RequestMethod.GET)
 	public  ResponseEntity<Page<ProducaoFiacao>> buscaProducaoFiacaoPag(
 			@PathVariable String idfil,
 			@RequestParam(value="page", defaultValue="0") Integer page, 
 			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage, 
 			@RequestParam(value="orderBy", defaultValue="d4cod") String orderBy, 
 			@RequestParam(value="direction", defaultValue="ASC") String direction) {	 
 		Page<ProducaoFiacao> lista = service.buscaProducaoFiacaoPag(page, linesPerPage, orderBy, direction, idfil  );
 		return ResponseEntity.status(HttpStatus.OK).body(lista);
 	}     
 	

 	@CrossOrigin
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaProducaoFiacao(@PathVariable String filial){   
		try {
 		    List<ProducaoFiacao> listaProducaoFiacao = service.buscaProducaoFiacao(filial);  
		    return ResponseEntity.status(HttpStatus.OK).body(listaProducaoFiacao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
			
	}
 	
/* 	
 	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/maquina/{maquina}/dataProd/{dataProd}/turno/{turno}/lado/{lado}/hora/{horaIni}", method=RequestMethod.GET)
	public ProducaoFiacao buscaProducaoFiacaoByPK(@PathVariable String filial , @PathVariable String maquina,@PathVariable  String dataProd,@PathVariable  String turno,@PathVariable  String lado, @PathVariable Integer horaIni){	 
		ProducaoFiacao obj = service.buscaProducaoFiacaoByPK( filial , maquina, dataProd, turno, lado,  horaIni );
		return  obj;	
		
	}   
 */
 	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/maquina/{maquina}/dataProd/{dataProd}/turno/{turno}/lado/{lado}/hora/{horaIni}", method=RequestMethod.GET)
	public  ResponseEntity<?>  pesquisaProducaoFiacaoByParambuscaProducaoFiacaoByPK(@PathVariable String filial , @PathVariable String maquina,@PathVariable  String dataProd,@PathVariable  String turno,@PathVariable  String lado, @PathVariable Integer horaIni){
		try {
 		   ProducaoFiacao obj = service.buscaProducaoFiacaoByPK( filial , maquina, dataProd, turno, lado,  horaIni );
		   return ResponseEntity.status(HttpStatus.OK).body(obj); 
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}      
 	
 	@CrossOrigin
 	@RequestMapping(value="/parametros", method=RequestMethod.POST) 	
	public  ResponseEntity<?>  pesquisaProducaoFiacaoByParam (@Valid @RequestBody ProducaoFiacaoDTO  objDTO ){
 		try {
	 		System.out.println("pesquisaProducaoFiacaoByParam   " + objDTO.getCodigoMaquina());
	 		List<ProducaoFiacao> listaProducaoFiacao = service.pesquisaProducaoFiacaoByParam(objDTO.getIdfil(),objDTO.getCodigoMaquina(),objDTO.getDataProducaoInicial(),objDTO.getDataProducaoFinal(),objDTO.getTipoMaquina(),objDTO.getTurno());
	 		return ResponseEntity.status(HttpStatus.OK).body(listaProducaoFiacao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 		
	}

 	@CrossOrigin
 	@RequestMapping(value="/calcefic", method=RequestMethod.POST)
	public  ResponseEntity<?> buscaDadosCalcEfic(@Valid @RequestBody ProducaoFiacaoDTO  objDTO ){  
        try {
 			List<Map<String, Object>> listaProducaoFiacao = service.buscaDadosCalcEfic(objDTO.getIdfil(),objDTO.getItem(),objDTO.getHoraInicio(),objDTO.getHoraFinal() );
	 		return ResponseEntity.status(HttpStatus.OK).body(listaProducaoFiacao);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 		
	}  		
 
 	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert (@Valid @RequestBody ProducaoFiacao  objDTO ){
 		try {
			service.insert(objDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Registro inserido com sucesso.");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}
	
 	@CrossOrigin
 	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody ProducaoFiacao objDTO ) { 
 		try {
			service.update(objDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Registro alterado com sucesso.");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}	 	
 	
 	@CrossOrigin
 	@RequestMapping(value="/datas", method=RequestMethod.POST)
 	public  ResponseEntity<?>  validaDatas (@Valid @RequestBody ProducaoFiacaoDTO  obj){  		
 		try {
	 		System.out.println("validaDatas   " + obj.getCodigoMaquina());
	 	    List<String>  validouData = service.validaData(obj);
	 		return ResponseEntity.status(HttpStatus.OK).body(validouData);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	} 	 
 
	@CrossOrigin
	@RequestMapping(value="/filial/{idfil}/codigo/{codigoMaquina}/turno/{turno}/data/{dataProducao}/lado/{lado}/hora/{horaInicio}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deletaProducaoFiacao(@PathVariable  String idfil, @PathVariable  String codigoMaquina  , @PathVariable  String dataProducao, @PathVariable String turno,   @PathVariable  String lado,  @PathVariable Integer horaInicio) throws SQLException{  
		try {
			service.deletaProducaoFiacao(idfil, codigoMaquina, dataProducao, turno, lado, horaInicio);
			return ResponseEntity.status(HttpStatus.OK).body("Produção excluida com sucesso.");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  	
	}	
  	
 	@CrossOrigin
 	@RequestMapping(value="/numApontamentos/filial/{filial}/maquina/{maquina}/dataProd/{dataProd}/turno/{turno}/lado/{lado}", method=RequestMethod.GET)
 	public ResponseEntity<?> numApontamentos (@PathVariable  String filial, @PathVariable  String maquina  , @PathVariable  String dataProd, @PathVariable String turno,   @PathVariable  String lado ) throws SQLException{ 	
 		try {
	 		List<Map<String, Object>> totApontamentos = service.numApontamentos(filial, maquina, dataProd, turno, lado);
	 		return ResponseEntity.status(HttpStatus.OK).body(totApontamentos);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  	
	}  	
    	
	

}
