package com.santanatextiles.cpf.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class OperadorDTO { 
	 
	private String idfil; 
	private String codigo;	 
	private String nome;	 
	private String tipoMaquina;	 
	private String turno;	 
	private String horasDisponiveis;	 
	private String folguista;	 
	private String grupoContraMestre; 	 
	private String senha; 
	
	public OperadorDTO() {
	 
	} 
	public OperadorDTO(String idfil, String codigo, String nome, String tipoMaquina, String turno,
			String horasDisponiveis, String folguista, String grupoContraMestre, String senha) {
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
	
	
	
	
	
	

}
