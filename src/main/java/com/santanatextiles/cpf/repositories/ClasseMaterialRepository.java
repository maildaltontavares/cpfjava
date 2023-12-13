package com.santanatextiles.cpf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santanatextiles.cpf.domain.ClasseMaterial;

@Repository
public interface ClasseMaterialRepository  extends JpaRepository<ClasseMaterial, Integer> {
	
	/*
    @Transactional(readOnly=true)
    List<ClasseMaterial> findByLocalizacaoContains(Integer id) ; 
     
    */
    
	@Query(value =  
		      "Select d0403_id_classe_material,d0403_nome,d0003_id_localizacao    " +
		      " from stl.E0403_STL_CLASSE_MATERIAL " +
		      " where d0003_id_localizacao =   ?1 order by d0403_nome",nativeQuery = true)	 
	List<ClasseMaterial> buscaClasseMaterialPorLocalizacao(Integer localizacao);    
    
	@Query(value =  
		      "Select d0403_id_classe_material,d0403_nome,d0003_id_localizacao    " +
		      " from stl.E0403_STL_CLASSE_MATERIAL " +
		      " where d0003_id_localizacao =   ?1 ",nativeQuery = true)	 
	Page<ClasseMaterial> buscaClasseMaterialPorLocalizacaoPag(PageRequest pageRequest, @Param("localizacao") Integer localizacao);    
	
    @Query(value = 
      "Select d0403_id_classe_material ,  d0403_nome   ,d0003_id_localizacao     " +
      " from stl.e0403_stl_classe_material   " +
      " where d0003_id_localizacao = ?1 and d0403_nome like %?2% order by d0403_nome" ,nativeQuery = true)
	List<ClasseMaterial> buscaClasseMaterialPorNome(Integer localizacao,String nome) ; 	
	
	
    @Query(value = 
    	      "Select d0403_id_classe_material ,  d0403_nome   ,d0003_id_localizacao     " +
    	      " from stl.e0403_stl_classe_material   " +
    	      " where d0403_id_classe_material = ?1 " ,nativeQuery = true)
    		ClasseMaterial buscaClasseMaterialById(Integer id) ; 	    
    
	
}
