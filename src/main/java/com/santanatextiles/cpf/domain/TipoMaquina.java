package com.santanatextiles.cpf.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="CPFB2_DBF",schema="CPF")
@IdClass(TipoMaquinaId.class)
public class TipoMaquina  implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="B2COD")
	private String codigo; 
	
	@Column(name="B2DESC")
	private String nome;
	
	@Column(name="B2CLASMAT")
	private Integer cdClasse;

	@Transient
	private String dsClasse; 
	
	@ManyToOne
	@JoinColumn(name="B2CLASMAT", insertable = false, updatable = false) 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ClasseMaterial classeMaterial; 
	
	public TipoMaquina() {		
		
	}  
 
 
	
	public TipoMaquina(String idfil, String codigo, String nome, Integer cdClasse, String dsClasse,
			ClasseMaterial classeMaterial) {
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

	public Integer getCdClasse() {
		return cdClasse;
	}

	public void setCdClasse(Integer cdClasse) {
		this.cdClasse = cdClasse;
	}
 

	public ClasseMaterial getClasseMaterial() {
		return classeMaterial;
	}

	public void setClasseMaterial(ClasseMaterial classeMaterial) {
		this.classeMaterial = classeMaterial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, idfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoMaquina other = (TipoMaquina) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}
	
	
	

}
