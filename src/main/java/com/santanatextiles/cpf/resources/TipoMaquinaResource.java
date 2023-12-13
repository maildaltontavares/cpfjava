package com.santanatextiles.cpf.resources;

import java.util.List;

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
import com.santanatextiles.cpf.domain.TipoMaquina;
import com.santanatextiles.cpf.dto.TipoMaquinaDTO;
import com.santanatextiles.cpf.services.TipoMaquinaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/tipomaquina")
public class TipoMaquinaResource {
	
	@Autowired
	private TipoMaquinaService service; 
	 
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/paginado",method=RequestMethod.GET)
	public  ResponseEntity<Page<TipoMaquina>> buscaTipoMaquinaPag(
			@PathVariable String filial,
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="20") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="b2cod") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {	 
		Page<TipoMaquina> lista = service.buscaTipoMaquinaPag(page, linesPerPage, orderBy, direction, filial  );
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaTipoMaquina(@PathVariable String filial){  
		try {
		   List<TipoMaquina> listaMaquinas = service.buscaTipoMaquina(filial);  
		   return ResponseEntity.status(HttpStatus.OK).body(listaMaquinas);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  
	}
 
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/tipomaquina/{tipoMaquina}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaTipoMaquinaById(@PathVariable String filial,@PathVariable String tipoMaquina){  
		try {
			TipoMaquina cTipoMaquina = service.buscaTipoMaquinaById(filial,tipoMaquina);  
			return ResponseEntity.status(HttpStatus.OK).body(cTipoMaquina);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 
	}	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/nome/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaTipoMaquinaByNome(@PathVariable String filial,@PathVariable String nome){  
		try {
			List<TipoMaquina> listaMaquinas = service.buscaTipoMaquinaByNome(filial,nome);  
			return ResponseEntity.status(HttpStatus.OK).body(listaMaquinas);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert (@Valid @RequestBody TipoMaquinaDTO objDTO ){ 
		try {
			TipoMaquina obj =   service.fromDTO(objDTO);	 
			obj = service.insert(obj);
			return ResponseEntity.status(HttpStatus.OK).body(obj.getCodigo());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 
	}
	
	@CrossOrigin
 	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody TipoMaquinaDTO objDTO ) {  
		try {
			TipoMaquina obj = service.fromDTO(objDTO);		
			obj = service.update(obj);
			return ResponseEntity.status(HttpStatus.OK).body( obj.getCodigo());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{idfil}/codigo/{codigo}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deletaTipoMaquina(@PathVariable  String idfil, @PathVariable  String codigo){  
		try {
			service.deletaTipoMaquina(idfil,codigo);
			return ResponseEntity.status(HttpStatus.OK).body(  codigo);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	}
	
	
	 
	

}
