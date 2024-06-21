package com.santanatextiles.cpf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.cpf.domain.Item;
import com.santanatextiles.cpf.domain.ItemId;
import com.santanatextiles.cpf.domain.TipoMaquina;
import com.santanatextiles.cpf.repositories.ItemRepository;
import com.santanatextiles.cpf.resources.utils.URL;
 

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repo;
	
	@Autowired
	private TipoMaquinaService tipoMaquinaService;
	
	public List<Item> buscaItem(Long idfil){	 
		List<Item> obj = repo.buscaItem(idfil); 
		return  obj;							 
	}	
	
    public Page<Item> buscaItemPag(Integer page, Integer linesPerPage, String orderBy, String direction, Long idfil) {
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);  
	return repo.buscaItemPag(pageRequest, idfil);
    }	
    
	public Item buscar(String idfil, Long codigo) {
		Long localizacao = URL.codigoLocalizacao(idfil);
		Optional<Item> obj = repo.findById(new ItemId(localizacao,codigo));
		return obj.orElse(null);
	}
	
	 
	public Item buscarItemClasse(String idfil, Long codigo, String tipoMaquina) {
		
		Long localizacao = URL.codigoLocalizacao(idfil);
		TipoMaquina tpMaq = tipoMaquinaService.buscaTipoMaquinaById(idfil,tipoMaquina);
		
		 Item  obj =  repo.procuraPorCodigoClasse(Long.valueOf(idfil), codigo , tpMaq.getCdClasse());
		return obj ;
	}
	
		 
	
	public List<Item> procuraPorDescricaoClasse(String idfil,String descricao,String tipoMaquina) {
		Long localizacao = URL.codigoLocalizacao(idfil);
		
		TipoMaquina tpMaq = tipoMaquinaService.buscaTipoMaquinaById(idfil,tipoMaquina);
		return repo.procuraPorDescricaoClasse(localizacao, Long.valueOf(idfil), descricao.toUpperCase(),tpMaq.getCdClasse());
	}
 
	public List<Item> procuraPorDescricao(String idfil,String descricao) {
		Long localizacao = URL.codigoLocalizacao(idfil);
		return repo.procuraPorDescricao(localizacao, Long.valueOf(idfil), descricao.toUpperCase());
	}	
	    
    
    
}    
