package com.santanatextiles.cpf.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.cpf.domain.TipoMaquina;
import com.santanatextiles.cpf.domain.TipoMaquinaId;
import com.santanatextiles.cpf.dto.TipoMaquinaDTO;
import com.santanatextiles.cpf.repositories.ClasseMaterialRepository;
import com.santanatextiles.cpf.repositories.IdfilRepository;
import com.santanatextiles.cpf.repositories.TipoMaquinaRepository;
import com.santanatextiles.cpf.resources.exception.DataIntegrityException;
import com.santanatextiles.cpf.resources.exception.ObjectNotFoundException;
 
 

@Service
public class TipoMaquinaService {
	
		@Autowired
		private TipoMaquinaRepository repostitory;
		
		@Autowired
		private IdfilRepository rep;	
		
		@Autowired
		private ClasseMaterialRepository classeRepository;
		
		private ArrayList<String> msg = new ArrayList<>(); 
		
		
		public String buscaFil(String tabela,String filial){
			return rep.buscaFilial(tabela,filial);   
		}		
		
		public List<TipoMaquina> buscaTipoMaquina(String filial){			 
			String idfil = buscaFil("CPFB2", filial); 
			List<TipoMaquina> obj = repostitory.buscaTipoMaquina(idfil); 
			return  obj;							 
		}	
		
		public List<TipoMaquina> buscaTipoMaquinaByNome(String filial,String nome){			 
			String idfil = buscaFil("CPFB2", filial); 
			nome = nome.toUpperCase();
			List<TipoMaquina> obj = repostitory.buscaTipoMaquinaByNome(idfil,nome); 
			return  obj;							 
		}	
		
		 public void deletaTipoMaquina(String filial,String codigo){	
			   String idfil = buscaFil("CPFB2", filial);   
		 	  repostitory.deleteByIdfilAndCodigo(idfil,codigo);  
		}			
		
        public Page<TipoMaquina> buscaTipoMaquinaPag(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);  
		return repostitory.buscaTipoMaquinaPag(pageRequest, idfil);
	    }	

		
		public TipoMaquina buscaTipoMaquinaById(String filial, String tipoMaquina) { 
			String idfil = buscaFil("CPFB2", filial);			
			Optional<TipoMaquina> obj = repostitory.findById(new TipoMaquinaId(idfil,tipoMaquina)) ;  
			return obj.orElse(null);
		}
		
		@Transactional
		public TipoMaquina insert(TipoMaquina obj) {	
			
			String novoCodigo = repostitory.CodigoNovoTipoMaquina(obj.getIdfil());
			obj.setNome(obj.getNome().toUpperCase());
			
			verificaEntidades(obj); 
			
			if (this.msg.isEmpty()) {			
				buscaTipoMaquinaById(obj.getIdfil(),obj.getCodigo()); 
			} else {
				throw new DataIntegrityException(String.join(",", this.msg)); 
			}			
			
			obj.setIdfil(buscaFil("CPFB2", obj.getIdfil()));
			obj.setCodigo(novoCodigo);
			
			return repostitory.save(obj);			
		}
		 
		public TipoMaquina fromDTO(TipoMaquinaDTO objDTO) {
			return new TipoMaquina(
					objDTO.getIdfil(),
					objDTO.getCodigo(),
					objDTO.getNome(),
					objDTO.getCdClasse(),
					objDTO.getDsClasse(),
					objDTO.getClasseMaterial()
					);
     	}	
		
		@Transactional
		public TipoMaquina update(TipoMaquina obj) {

			obj.setIdfil(buscaFil("CPFB2", obj.getIdfil())); 
			obj.setCodigo(obj.getCodigo());
			obj.setNome(obj.getNome().toUpperCase());
			
			verificaEntidades(obj);

			if (this.msg.isEmpty()) {
				if (buscaTipoMaquinaById(obj.getIdfil(),obj.getCodigo()) == null) {
					this.msg.add("Tipo Maquina LLLL: "+obj.getCodigo()+" Não Existe");
				}
			}
			
			if (!this.msg.isEmpty()) {
				throw new ObjectNotFoundException(String.join(",", this.msg)); 
			} 
			
			
			
			return repostitory.save(obj);
			
		}	 
		
		 private void verificaEntidades(TipoMaquina obj) {			 
			 this.msg.clear();
				try {
					if(obj.getNome() == null) {
					  this.msg.add("Nome não informado");
					}  
				}			
				catch (Exception e) {			
				}
				return; 			 
		 }
			
			
			
 
	   	
		
}
