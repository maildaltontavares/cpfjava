package com.santanatextiles.cpf.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.cpf.domain.FichaTecnica;
import com.santanatextiles.cpf.services.FichaTecnicaService;

@RestController
@RequestMapping(value="/fichatecnica")
public class FichaTecnicaResource {
	
	@Autowired
	private FichaTecnicaService service;
	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{idfil}/item/{item}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaTurno(@PathVariable String idfil,@PathVariable String item){ 
		try {
			FichaTecnica ft = service.buscaFichaTecnicaItem(idfil, item);  
			return ResponseEntity.status(HttpStatus.OK).body(ft);		
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 
	}	
	

}
