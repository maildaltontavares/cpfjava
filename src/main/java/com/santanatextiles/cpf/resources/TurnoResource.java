package com.santanatextiles.cpf.resources;

import java.util.List;
import java.util.Map;

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

import com.santanatextiles.cpf.domain.Turno;
import com.santanatextiles.cpf.services.TurnoService;

@RestController
@RequestMapping(value="/turno")
public class TurnoResource {
	
	@Autowired
	private TurnoService service; 
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/paginado",method=RequestMethod.GET)
	public  ResponseEntity<Page<Turno>> buscaTurnoPag(
			@PathVariable String filial,
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="K1CDTURN") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {	 
		Page<Turno> lista = service.buscaTurnoPag(page, linesPerPage, orderBy, direction, filial  );
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}	
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaTurno(@PathVariable String filial){  
		try {
			List<Turno> listaTurno = service.buscaTurno(filial);  
			return ResponseEntity.status(HttpStatus.OK).body(listaTurno);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		 
	}
	
	@CrossOrigin
	@RequestMapping(value="/filial/{filial}/tur/{Turno}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaTurnoById(@PathVariable String filial,@PathVariable String Turno){  
		try {
			Turno cTurno = service.buscaTurnoById(filial,Turno);  
			return ResponseEntity.status(HttpStatus.OK).body(cTurno);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 	 
	}	 
	
	@CrossOrigin
	@RequestMapping(value="/horariosturnos/{filial}", method=RequestMethod.GET)
	public ResponseEntity<? > buscaHorariosTurno(@PathVariable String filial ){  
		try {		
			List<Map<String, Object>>  cTurno = service.buscaHorariosTurno(filial);  
			return ResponseEntity.status(HttpStatus.OK).body(cTurno);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
		
	}		
		

}
