package com.santanatextiles.cpf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santanatextiles.cpf.domain.Item;
import com.santanatextiles.cpf.domain.ItemId; 

@Repository
public interface ItemRepository extends JpaRepository<Item , ItemId> {
	

	   @Query(value =  
	      "Select D0422_ID_ITEM,D0002_ID_FIL ,it.D0003_ID_LOCALIZACAO ,it.D0421_ID_MATERIAL  " +  
	      " from stl.e0422_stl_item it" +
	      " inner join stl.e0421_stl_material mat on it.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL " +
	      " where it.d0002_id_fil =   ?1 ",nativeQuery = true)
	    List<Item> buscaItem(Long filial) ; 
	     
	   @Query(value =  
		  "Select D0422_ID_ITEM,D0002_ID_FIL ,it.D0003_ID_LOCALIZACAO ,it.D0421_ID_MATERIAL  " +  
	      " from stl.e0422_stl_item it " +
	      " inner join stl.e0421_stl_material mat on it.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL " +
	      " where it.d0002_id_fil =   ?1 order by d0421_nome",nativeQuery = true)
	    Page<Item> buscaItemPag(PageRequest pageRequest, @Param("idfil") Long filial) ;   
	   
	    
		@Query(value="Select D0422_ID_ITEM,D0002_ID_FIL ,it.D0003_ID_LOCALIZACAO ,it.D0421_ID_MATERIAL, mat.D0403_ID_CLASSE_MATERIAL  "
				+ " from stl.e0422_stl_item it  "
				+ "  inner join stl.e0421_stl_material mat on it.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL  "    
		+ "WHERE  it.D0002_ID_FIL = :idfil "
		+ "AND    it.D0422_ID_ITEM  = :item "
		+ "AND    mat.D0403_ID_CLASSE_MATERIAL = :classeMaterial "
		,nativeQuery = true)
        Item procuraPorCodigoClasse(Long idfil,  Long item,  Integer classeMaterial);		   
	   
	    
	   
		@Query(value="SELECT i "
		+ "FROM Item i "
		+ "WHERE i.localizacao = :localizacao "
		+ "AND i.idfil = :idfil "
		+ "AND UPPER(i.material.descricao) LIKE %:descricao% "
		+ "AND  i.material.classeMaterial = :classeMaterial "
		+ "ORDER BY i.material.descricao")
       List<Item> procuraPorDescricaoClasse(Long localizacao , Long idfil,  String descricao, Integer classeMaterial);	   
	    
		@Query(value="SELECT i "
		+ "FROM Item i "
		+ "WHERE i.localizacao = :localizacao "
		+ "AND i.idfil = :idfil "
		+ "AND UPPER(i.material.descricao) LIKE %:descricao% "
		+ "ORDER BY i.material.descricao")
        List<Item> procuraPorDescricao(Long localizacao , Long idfil,  String descricao);
        
         
	   
/*		
	   @Query(value =  
				  "Select D0422_ID_ITEM,D0002_ID_FIL ,it.D0003_ID_LOCALIZACAO ,it.D0421_ID_MATERIAL, mat.D0421_NOME descricao  " +  
			      " from stl.e0422_stl_item it " +
			      " inner join stl.e0421_stl_material mat on it.D0421_ID_MATERIAL = mat.D0421_ID_MATERIAL " + 
			      " where it.d0002_id_fil =   ?1 " +
			       "AND UPPER(mat.D0421_NOME) LIKE %:descricao% order by d0421_nome ",nativeQuery = true)
	   List<Item> buscaFioPorDescricao(Long localizacao , Long idfil,  String descricao , Double classeMaterial);
		*/
		
	   

}

