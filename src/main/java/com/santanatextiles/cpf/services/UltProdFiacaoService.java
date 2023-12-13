package com.santanatextiles.cpf.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.cpf.customQueryResults.UltProdFiacao;
import com.santanatextiles.cpf.repositoriesCustomQuery.UltProdFiacaoRepository;

@Service
public class UltProdFiacaoService {
	
	@Autowired
	private UltProdFiacaoRepository repo;
	
	public UltProdFiacao pesquisaUltimaProducao(String filial, String maquina, String lado) { 		 	
		UltProdFiacao obj = repo.pesquisaUltimaProducao(filial, maquina, lado ) ;  
		return obj;
	}	
	

}
