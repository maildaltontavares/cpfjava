package com.santanatextiles.cpf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.cpf.domain.Operador;
import com.santanatextiles.cpf.repositories.OperadorRepository;

@Service
public class OperadorService {
	
	@Autowired
	private OperadorRepository repo;
	

	
	
	 public List<Operador> buscaPorNome(String filial,String nome){	  
		 nome = nome.toUpperCase();
		 List<Operador> obj = repo.buscaOperadorPorNome(filial, nome) ;	  
		 	return obj;
	}	
	
	 public Operador buscaPorCodigo(String filial,String codigo){	  

		 	Optional<Operador> obj = Optional.ofNullable(repo.findByIdfilAndCodigo(filial, codigo));	  
		 	return obj.orElse(null);
	}
 
	 
	
}
