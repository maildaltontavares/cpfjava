package com.santanatextiles.cpf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.cpf.domain.ClasseMaterial;
import com.santanatextiles.cpf.repositories.ClasseMaterialRepository;

@Service
public class ClasseMaterialService {
	 

	@Autowired
	private ClasseMaterialRepository repo;	 
	
	 
	public List<ClasseMaterial> buscaClasseMaterialPorLocalizacao(Integer localizacao){	 
		List<ClasseMaterial> obj = repo.buscaClasseMaterialPorLocalizacao(localizacao); 
		return  obj;							 
	}	
	
    public Page<ClasseMaterial> buscaClasseMaterialPorLocalizacaoPag(Integer page, Integer linesPerPage, String orderBy, String direction, Integer localizacao) {
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);  
	return repo.buscaClasseMaterialPorLocalizacaoPag(pageRequest, localizacao);
    } 


	public List<ClasseMaterial> buscaClasseMaterialPorNome(Integer localizacao,String nome){	
		nome = nome.toUpperCase();
		List<ClasseMaterial> obj = repo.buscaClasseMaterialPorNome(localizacao,nome); 
		return  obj;							 
	}	    
	
	
	public ClasseMaterial buscaClasseMaterialById(Integer id){	 
		ClasseMaterial obj = repo.buscaClasseMaterialById(id); 
		return  obj;							 
	}		
	  
}
