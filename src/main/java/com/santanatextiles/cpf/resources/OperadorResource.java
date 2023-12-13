package com.santanatextiles.cpf.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.cpf.domain.Maquina;
import com.santanatextiles.cpf.domain.Operador;
import com.santanatextiles.cpf.services.OperadorService;

@RestController
@RequestMapping(value="/operador")
public class OperadorResource {
	
	@Autowired
	private OperadorService service;
	
	
	@CrossOrigin
	@RequestMapping(value="/{filial}/nome/{nome}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaPorNome(@PathVariable String filial,@PathVariable String nome){
		try {
			List<Operador> listaOperador = service.buscaPorNome(filial,nome);  
			return ResponseEntity.status(HttpStatus.OK).body(listaOperador);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/{filial}/codigo/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<? > buscaPorCodigo(@PathVariable String filial,@PathVariable String codigo){  
		try {
			 Operador  operador = service.buscaPorCodigo(filial,codigo);  
			return ResponseEntity.status(HttpStatus.OK).body(operador);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	}	
	

}
