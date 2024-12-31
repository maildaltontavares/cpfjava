package com.santanatextiles.cpf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.cpf.domain.FichaTecnica;
import com.santanatextiles.cpf.repositories.FichaTecnicaRepository;

@Service
public class FichaTecnicaService {
	
	@Autowired
	private FichaTecnicaRepository repo;
	
	public FichaTecnica buscaFichaTecnicaItem(String idfil, String codigo) {  
		
		FichaTecnica ft = repo.buscaFichaTecnicaItem(idfil, codigo);
		
		return ft;
	}	
	
	
	

}
