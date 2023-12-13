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

import com.santanatextiles.cpf.services.MaquinaService;

import jakarta.validation.Valid;

import com.santanatextiles.cpf.domain.Maquina;
import com.santanatextiles.cpf.domain.TipoMaquina;
import com.santanatextiles.cpf.dto.MaquinaDTO;

@RestController
@RequestMapping(value="/maquina")
public class MaquinaResource {
	
	@Autowired
	private MaquinaService service; 	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/paginado",method=RequestMethod.GET)
	public  ResponseEntity<Page<Maquina>> buscaMaquinaPag(
			@PathVariable String filial,
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="c3desc") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {	 
		Page<Maquina> lista = service.buscaMaquinaPag(page, linesPerPage, orderBy, direction, filial  );
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaMaquina(@PathVariable String filial){  
		try {
			List<Maquina> listaMaquinas = service.buscaMaquina(filial);  
			return ResponseEntity.status(HttpStatus.OK).body(listaMaquinas);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/nome/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaMaquinaPorNome(@PathVariable String filial,@PathVariable String nome){  
		try {		
			List<Maquina> listaMaquinas = service.buscaMaquinaPorNome(filial,nome);  
			return ResponseEntity.status(HttpStatus.OK).body(listaMaquinas);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	}
	
 
	@CrossOrigin   //(origins = {"http://localhost:8080"})	
	@RequestMapping(value="/filial/{filial}/maquinaf/{Maquina}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaMaquinaById(@PathVariable String filial,@PathVariable String Maquina){  
		try {
			Maquina cMaquina = service.buscaMaquinaById(filial,Maquina);  
			return ResponseEntity.status(HttpStatus.OK).body(cMaquina);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	}	
	
	@CrossOrigin   //(origins = {"http://localhost:8080"})	
	@RequestMapping(value="/filial/{filial}/local/{local}/tpMaq/{tipoMaquina}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaMaquinaPorLocal(@PathVariable String filial,@PathVariable String local,@PathVariable String tipoMaquina){
		try {
			Maquina cMaquina = service.buscaMaquinaPorLocal(filial,local,tipoMaquina);  
			return ResponseEntity.status(HttpStatus.OK).body(cMaquina);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}	
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insert (@Valid @RequestBody MaquinaDTO objDTO ){ 
		try {
			Maquina obj =   service.fromDTO(objDTO);	 
			obj = service.insert(obj);
			return ResponseEntity.status(HttpStatus.OK).body( obj.getCodigo());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<String> update(@Valid @RequestBody MaquinaDTO objDTO ) {
		try {
			Maquina obj = service.fromDTO(objDTO);		
			obj = service.update(obj);
			return ResponseEntity.status(HttpStatus.OK).body(obj.getCodigo());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}	
	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{idfil}/codigo/{codigo}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deletaMaquina(@PathVariable  String idfil, @PathVariable  String codigo){  
		try {
			service.deletaMaquina(idfil,codigo);
			return ResponseEntity.status(HttpStatus.OK).body( codigo);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
	}	

}
