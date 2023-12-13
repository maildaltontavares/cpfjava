package com.santanatextiles.cpf.dto;

import java.io.Serializable;

import com.santanatextiles.cpf.domain.ClasseMaterial;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;

 
public class TipoMaquinaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idfil;	
	private String codigo;
	
	@NotEmpty(message="Nome é Obrigatório!!!")
	private String nome;	
	private Integer cdClasse;   

	private String dsClasse;	
	
	private ClasseMaterial classeMaterial;	

	public TipoMaquinaDTO() {
		 
	}		  

	public TipoMaquinaDTO(String idfil, String codigo, @NotEmpty(message = "Nome é Obrigatório!!!") String nome,
			Integer cdClasse, String dsClasse, ClasseMaterial classeMaterial) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.nome = nome;
		this.cdClasse = cdClasse;
		this.dsClasse = dsClasse;
		this.classeMaterial = classeMaterial;
	}
	
	 
	
	public String getDsClasse() {
		return dsClasse;
	}
 

	public void setDsClasse(String dsClasse) {
		this.dsClasse = dsClasse;
	}

	public Integer getCdClasse() {
		return cdClasse;
	}

	public void setCdClasse(Integer cdClasse) {
		this.cdClasse = cdClasse;
	}	
	
	public String getIdfil() {
		return idfil;
	}
	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}
 
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ClasseMaterial getClasseMaterial() {
		return classeMaterial;
	}

	public void setClasseMaterial(ClasseMaterial classeMaterial) {
		this.classeMaterial = classeMaterial;
	}
	

	 
	

}
