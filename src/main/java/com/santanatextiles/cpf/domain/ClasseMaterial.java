package com.santanatextiles.cpf.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="E0403_STL_CLASSE_MATERIAL",schema="STL")
public class ClasseMaterial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="D0403_ID_CLASSE_MATERIAL")
	private Integer id;
	
	@Column(name="D0403_NOME")
	private String nome;	

	@Column(name="D0003_ID_LOCALIZACAO")
	private Integer localizacao;	
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="classeMaterial")
	private List<TipoMaquina> tipoMaquinas = new ArrayList<>();
	
	
	public ClasseMaterial() {
		 
	}  

	public ClasseMaterial(Integer id, String nome, Integer localizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
	}






	public List<TipoMaquina> getTipoMaquinas() {
		return tipoMaquinas;
	}
 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(Integer localizacao) {
		this.localizacao = localizacao;
	}	


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClasseMaterial other = (ClasseMaterial) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
