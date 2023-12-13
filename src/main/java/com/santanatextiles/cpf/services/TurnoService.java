package com.santanatextiles.cpf.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.cpf.domain.Turno;
import com.santanatextiles.cpf.domain.TurnoId;
import com.santanatextiles.cpf.repositories.IdfilRepository;
import com.santanatextiles.cpf.repositories.TurnoRepository;


@Service
public class TurnoService {

	@Autowired
	private TurnoRepository repostitory;
	
	@Autowired
	private IdfilRepository rep;		
	
	public String buscaFil(String tabela,String filial){
		return rep.buscaFilial(tabela,filial);   
	}	
	
    public List<Turno> buscaTurno(String filial){			 
			String idfil = buscaFil("PRDK1", filial); 
			List<Turno> obj = repostitory.buscaTurno(idfil); 
			return  obj;							 
		}		
		
     public Page<Turno> buscaTurnoPag(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);  
		return repostitory.buscaTurnoPag(pageRequest, idfil);
	    }	

		
	public Turno buscaTurnoById(String filial, String Turno) { 
		String idfil = buscaFil("PRDK1", filial);	
		Optional<Turno> obj = repostitory.findById(new TurnoId(idfil,Turno)) ;  
		return obj.orElse(null);
	}	
	
	
	
	public List<Map<String, Object>> buscaHorariosTurno (String filial){		
		return repostitory.buscaHorariosTurno(filial);		
		
	}


	
	
	
	
}
