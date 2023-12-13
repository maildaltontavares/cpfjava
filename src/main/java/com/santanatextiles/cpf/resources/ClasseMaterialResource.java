package com.santanatextiles.cpf.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.cpf.domain.ClasseMaterial;
import com.santanatextiles.cpf.services.ClasseMaterialService;

@RestController
@RequestMapping(value="/classematerial")
public class ClasseMaterialResource {
	
	@Autowired
	private ClasseMaterialService service;
	
	@CrossOrigin
	@RequestMapping(value="/localizacao/{localizacao}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaClasseMaterial(@PathVariable Integer localizacao){  
		try {
			List<ClasseMaterial> listaClasseMaterial = service.buscaClasseMaterialPorLocalizacao(localizacao);  
			return ResponseEntity.status(HttpStatus.OK).body(listaClasseMaterial);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
			
	}
	
	@CrossOrigin
 	@RequestMapping(value="/localizacao/{localizacao}/paginado",method=RequestMethod.GET)
 	public  ResponseEntity<Page<ClasseMaterial>> buscaClasseMaterialPorLocalizacao(
 			@PathVariable Integer localizacao,
 			@RequestParam(value="page", defaultValue="0") Integer page, 
 			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage, 
 			@RequestParam(value="orderBy", defaultValue="d0403_nome") String orderBy, 
 			@RequestParam(value="direction", defaultValue="ASC") String direction) {	 
 		Page<ClasseMaterial> lista = service.buscaClasseMaterialPorLocalizacaoPag(page, linesPerPage, orderBy, direction, localizacao  );
 		return ResponseEntity.status(HttpStatus.OK).body(lista);
 	}	
 	
 	//`http://localhost:8082/${tipo}/${nomeCampoProcura}/${procurarPor}`
 	//`http://localhost:8082/${tipo}/localizacao/${localizacao}/${nomeCampoProcura}/${procurarPor}`
 	//`http://localhost:8082/classematerial/localizacao/${nomeCampoProcura}/${procurarPor}`
 	
	@CrossOrigin
	@RequestMapping(value="/localizacao/{localizacao}/nome/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaClasseMaterialPorNome(@PathVariable Integer localizacao,@PathVariable String nome){  
		try {
			List<ClasseMaterial> listaClasseMaterial = service.buscaClasseMaterialPorNome(localizacao,nome);  
			return ResponseEntity.status(HttpStatus.OK).body(listaClasseMaterial);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
			
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity< ? > buscaClasseMaterialById(@PathVariable Integer id){  
		try {
			 ClasseMaterial listaClasseMaterial = service.buscaClasseMaterialById(id);  
			 return ResponseEntity.status(HttpStatus.OK).body(listaClasseMaterial);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 
			
	}	
	
	

}
