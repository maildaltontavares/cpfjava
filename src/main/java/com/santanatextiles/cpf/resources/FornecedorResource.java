package com.santanatextiles.cpf.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.cpf.domain.Fornecedor;
import com.santanatextiles.cpf.services.FornecedorService;



@RestController
@RequestMapping(value="/fornecedor")
public class FornecedorResource {
	
	@Autowired
	private FornecedorService service; 	
	
	
	@RequestMapping(value="/filial/{filial}", method=RequestMethod.GET)
	public ResponseEntity<?> buscaFornecedor(@PathVariable String filial){  
		try {
			List<Fornecedor> listaFornecedor = service.buscaFornecedor(filial);  
			return ResponseEntity.status(HttpStatus.OK).body(listaFornecedor);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		} 		
			
	}
	
 	@RequestMapping(value="/filial/{filial}/paginado",method=RequestMethod.GET)
 	public  ResponseEntity<Page<Fornecedor>> buscaFornecedorPag(
 			@PathVariable String filial,
 			@RequestParam(value="page", defaultValue="0") Integer page, 
 			@RequestParam(value="linesPerPage", defaultValue="5") Integer linesPerPage, 
 			@RequestParam(value="orderBy", defaultValue="b2nome") String orderBy, 
 			@RequestParam(value="direction", defaultValue="ASC") String direction) {	 
 		Page<Fornecedor> lista = service.buscaFornecedorPag(page, linesPerPage, orderBy, direction, filial  );
 		return ResponseEntity.status(HttpStatus.OK).body(lista);
 	}	
	
	
	

}
