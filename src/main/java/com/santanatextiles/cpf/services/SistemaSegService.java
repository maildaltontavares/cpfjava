package com.santanatextiles.cpf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.cpf.domain.SistemaSeg;
import com.santanatextiles.cpf.repositories.SistemaSegRepository;

@Service
public class SistemaSegService {

	@Autowired
	private SistemaSegRepository repo;
	
	public List<SistemaSeg> buscaSistema(){		
		return repo.buscaSistema();
	}
	
	public SistemaSeg findById(Long id) {		
		Optional<SistemaSeg> sistemaSeg = repo.findById(id);
		return sistemaSeg.orElse(null);
	}
	
	
}
