package com.santanatextiles.cpf.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="PRDE5_DBF",schema="PRD")
@IdClass(OperadorId.class)
public class Operador implements Serializable {	

	private static final long serialVersionUID = 1L;	

	@Id
	@Column(name="IDFIL")
	private String  idfil;
	
	@Id
	@Column(name="E5CDOPER")
	private String codigo;
	
	@Column(name="E5NOMEOP")
	private String nome;
	
	@Column(name="E5TIPMAQ")
	private String tipoMaquina;
	
	@Column(name="E5CDTURN")
	private String turno;
	
	@Column(name="E5HSDISP")
	private String horasDisponiveis;
	
	@Column(name="E5FOLG")
	private String folguista;
	
	@Column(name="E5GPCMT")
	private String grupoContraMestre; 
	
	@Column(name="E5SENHA")
	private String senha;

	public Operador() {
	  
	}

	public Operador(String idfil, String codigo, String nome, String tipoMaquina, String turno, String horasDisponiveis,
			String folguista, String grupoContraMestre, String senha) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.nome = nome;
		this.tipoMaquina = tipoMaquina;
		this.turno = turno;
		this.horasDisponiveis = horasDisponiveis;
		this.folguista = folguista;
		this.grupoContraMestre = grupoContraMestre;
		this.senha = senha;
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

	public String getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getHorasDisponiveis() {
		return horasDisponiveis;
	}

	public void setHorasDisponiveis(String horasDisponiveis) {
		this.horasDisponiveis = horasDisponiveis;
	}

	public String getFolguista() {
		return folguista;
	}

	public void setFolguista(String folguista) {
		this.folguista = folguista;
	}

	public String getGrupoContraMestre() {
		return grupoContraMestre;
	}

	public void setGrupoContraMestre(String grupoContraMestre) {
		this.grupoContraMestre = grupoContraMestre;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Operador other = (Operador) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(idfil, other.idfil);
	}
 
	
	
	
	 
	
	
	
}
