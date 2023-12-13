package com.santanatextiles.cpf.resources;
 

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.cpf.domain.UsuarioLogin;
import com.santanatextiles.cpf.dto.UsuarioLoginDTO;
import com.santanatextiles.cpf.services.UsuarioLoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/")
public class LoginResource {

	@Autowired
	private UsuarioLoginService service;
	
 	@CrossOrigin
 	@RequestMapping(value="/login", method=RequestMethod.POST)
	public  ResponseEntity<?>findByLoginAndIdSistema(@Valid @RequestBody UsuarioLoginDTO  objDTO ){ 
 		
	 	try {
	 		UsuarioLogin usuarioLogin = service.findByLoginAndIdSistema(objDTO);
	 		return ResponseEntity.status(HttpStatus.OK).body(usuarioLogin);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}  		
	}	 	
 	
 	
	 	
	
}

