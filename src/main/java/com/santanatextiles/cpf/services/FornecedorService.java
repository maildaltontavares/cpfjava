package com.santanatextiles.cpf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.cpf.domain.Fornecedor;
import com.santanatextiles.cpf.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repo;
	
	public List<Fornecedor> buscaFornecedor(String idfil){	 
		List<Fornecedor> obj = repo.buscaFornecedor(idfil); 
		return  obj;							 
	}	
	
    public Page<Fornecedor> buscaFornecedorPag(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil) {
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);  
	return repo.buscaFornecedorPag(pageRequest, idfil);
    }	 
	
	
}
