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

 
import com.santanatextiles.cpf.domain.Maquina;
import com.santanatextiles.cpf.domain.MaquinaId;
import com.santanatextiles.cpf.domain.TipoMaquina;
import com.santanatextiles.cpf.dto.MaquinaDTO;
import com.santanatextiles.cpf.repositories.MaquinaRepository;
import com.santanatextiles.cpf.resources.exception.DataIntegrityException;
import com.santanatextiles.cpf.resources.exception.ObjectNotFoundException;
 

@Service
public class MaquinaService {
	
	
	@Autowired
	private MaquinaRepository repostitory;	
	
	@Autowired
	private TipoMaquinaService tipoMaquinaService;		
	
	private ArrayList<String> msg = new ArrayList<>(); 
	
    public List<Maquina> buscaMaquina(String filial){  
          return  repostitory.buscaMaquina(filial);							 
    }		
	
    public Page<Maquina> buscaMaquinaPag(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil) {
	      PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);  
	      return repostitory.buscaMaquinaPag(pageRequest, idfil);
    }	
	
    public Maquina buscaMaquinaById(String filial, String maquina) {  
	 	Optional<Maquina> obj = repostitory.findById(new MaquinaId(filial,maquina)) ;  
	 	return obj.orElse(null);
     }	 
    
    
    public Maquina buscaMaquinaPorLocal(String filial, String maquina,String tipoMaquina) {   
	 	//Optional<Maquina> obj = Optional.ofNullable(repostitory.buscaMaquinaPorLocal(filial,maquina,tipoMaquina));	 
    	 Maquina  obj =  repostitory.buscaMaquinaPorLocal(filial,maquina,tipoMaquina) ;
	 	//return obj.orElse(null);
    	 return obj;
     }    
    
    public List<Maquina> buscaMaquinaPorNome(String filial, String nome) {  
    	nome = nome.toUpperCase();  
	 	return repostitory.buscaMaquinaPorNome( filial,nome) ; 
     }	
    
	 public void deletaMaquina(String filial,String codigo){	  
	 	  repostitory.deleteByIdfilAndCodigo(filial,codigo);  
	}	      
		
	@Transactional
	public Maquina insert(Maquina obj) {	 
		
		obj.setNome(obj.getNome().toUpperCase());
		
		verificaEntidades(obj); 
		
		if (this.msg.isEmpty()) {			
			buscaMaquinaById(obj.getIdfil(),obj.getCodigo()); 
		} else {
			throw new DataIntegrityException(String.join(",", this.msg)); 
		} 
		  		
		return repostitory.save(obj);			
	}
	
	
	@Transactional
	public Maquina update(Maquina obj) { 
		
		obj.setNome(obj.getNome().toUpperCase());
	
		verificaEntidades(obj);

		if (this.msg.isEmpty()) {
			if (buscaMaquinaById(obj.getIdfil(),obj.getCodigo()) == null) {
				this.msg.add("Maquina : "+obj.getCodigo()+" Não Existe");
			}
		}
		
		if (!this.msg.isEmpty()) {
			throw new ObjectNotFoundException(String.join(",", this.msg)); 
		} 
		
		return repostitory.save(obj);
		
	}	
	
	 private void verificaEntidades(Maquina obj) {			 
		 this.msg.clear();
			try {
				
				if(obj.getIdfil() == null) {
					  this.msg.add("Filial não informada");
			    }  					
				
				if(obj.getCodigo() == null) {
					  this.msg.add("Codigo não informado");
			    }  								
				
				if(obj.getNome() == null) {
				  this.msg.add("Nome não informado");
				} 
			 
				
				if(  obj.getCodigo().substring(0, 2).intern() != obj.getIdfil().intern()) {
					this.msg.add("Os dois primeiros caracteres devem ser o numero da filial.");
			    }				
				 
				TipoMaquina tipoMaquina = tipoMaquinaService.buscaTipoMaquinaById(obj.getIdfil(), obj.getCodigo().substring(2, 4).toString() );
				if ( tipoMaquina == null) {
					this.msg.add("Tipo Maquina não existente"); 
				};
				 
				if(obj.getCodigo().length() != 6) {
				    this.msg.add("Tamanho do campo codigo invalido.");
			    }	 
				 
			}			
			catch (Exception e) {			
			}
			return; 			 
	 }	
	 
	public Maquina fromDTO(MaquinaDTO objDTO) {
		return new Maquina(
				objDTO.getIdfil(),
				objDTO.getCodigo(),
				objDTO.getNome(),
				objDTO.getEmpresa(),
				objDTO.getNumFusos(),	
				objDTO.getRpm(),
				objDTO.getCodigoAbertura(),
				objDTO.getNumSerie(),
				objDTO.getLocalFisico(),
				objDTO.getMqSSM(),
				objDTO.getLado(),
				objDTO.getTitulo(),
				objDTO.getHrTrabDia()
				 
				);
 	 }	    
	

}
