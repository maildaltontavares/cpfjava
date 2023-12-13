package com.santanatextiles.cpf.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.cpf.domain.TipoMaquina;
import com.santanatextiles.cpf.domain.TipoMaquinaId;
 
@Repository 
public interface TipoMaquinaRepository extends JpaRepository<TipoMaquina, TipoMaquinaId>   {
	 
    @Query(value = 
      "Select idfil,b2cod  ,b2desc, b2clasmat,  d0403_nome  dsClasse     " +
      " from cpf.cpfb2_dbf b2 left join stl.e0403_stl_classe_material on d0403_id_classe_material = b2clasmat " +
      " where b2.idfil =  STL.FN_STL_IDFIL('CPFB2',?1) and b2clasmat is not null order by b2desc",nativeQuery = true)
	List<TipoMaquina> buscaTipoMaquina(String filial) ; 
     
    @Query(value = 
    	      "Select idfil,b2cod  ,b2desc, b2clasmat,  d0403_nome  dsClasse     " +
    	      " from cpf.cpfb2_dbf b2 left join stl.e0403_stl_classe_material on d0403_id_classe_material = b2clasmat " +
    	      " where b2.idfil =  STL.FN_STL_IDFIL('CPFB2',?1)",nativeQuery = true)
    Page<TipoMaquina> buscaTipoMaquinaPag(PageRequest pageRequest, @Param("idfil") String idfil) ;     

    @Query(value = 
  	      "Select idfil,b2cod  ,b2desc, b2clasmat,  d0403_nome  dsClasse     " +
  	      " from cpf.cpfb2_dbf b2 left join stl.e0403_stl_classe_material on d0403_id_classe_material = b2clasmat " +
  	      " where b2.idfil =  STL.FN_STL_IDFIL('CPFB2',?1) and b2cod = ?2  ",nativeQuery = true)
     TipoMaquina buscaTipoMaquinaById(@Param("idfil") String idfil, @Param("codigo") String codigo) ;   
    
    @Transactional(readOnly=true)
    List<TipoMaquina> findByNomeContains(String nome) ; 
	
	@Query(value = "Select LPAD(NVL(MAX(b2cod),0)+1,2,'0') from cpf.cpfb2_dbf b2 where b2.idfil =  STL.FN_STL_IDFIL('CPFB2',?1) and b2cod < '99'",nativeQuery = true)
	String CodigoNovoTipoMaquina(@Param("idfil") String idfil);
	
    @Query(value = 
    	      "Select idfil,b2cod  ,b2desc, b2clasmat,  d0403_nome  dsClasse     " +
    	      " from cpf.cpfb2_dbf b2 left join stl.e0403_stl_classe_material on d0403_id_classe_material = b2clasmat " +
    	      " where b2.idfil =  STL.FN_STL_IDFIL('CPFB2',?1) and b2desc like %?2%  and b2clasmat is not null order by b2desc ",nativeQuery = true)
    List<TipoMaquina> buscaTipoMaquinaByNome(@Param("idfil") String idfil, @Param("nome") String nome) ; 	
	
 /*
    @Transactional
	@Query(value="DELETE FROM cpf.cpfb2_dbf b2 where b2.idfil = STL.FN_STL_IDFIL('CPFB2',:idfil) and b2cod = :codigo", nativeQuery = true)
	Long deletaTipoMaquina(@Param("idfil") String idfil,@Param("codigo") String codigo);
*/	
	 
	@Transactional
	Long deleteByIdfilAndCodigo(String idfil,String codigo);
	 
	

}
