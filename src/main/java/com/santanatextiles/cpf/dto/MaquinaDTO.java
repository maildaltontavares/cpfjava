package com.santanatextiles.cpf.dto;

import java.io.Serializable; 

import jakarta.validation.constraints.NotEmpty;

 
public class MaquinaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idfil;	
	private String codigo;
	
	@NotEmpty(message="Nome é Obrigatório!!!")
	private String nome;  
	
 	private String  empresa;
	private Integer numFusos;
	private Integer rpm;
	private String  codigoAbertura;
	private String  numSerie;
	private String  localFisico;
	private String  mqSSM;
	private String  lado;
	private Double  titulo;
	private String  hrTrabDia;	

	public MaquinaDTO() {
		 
	}		  
	
	public MaquinaDTO(String idfil, String codigo, @NotEmpty(message = "Nome é Obrigatório!!!") String nome,
			String empresa, Integer numFusos, Integer rpm, String codigoAbertura, String numSerie, String localFisico,
			String mqSSM, String lado, Double titulo, String hrTrabDia) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.nome = nome;
		this.empresa = empresa;
		this.numFusos = numFusos;
		this.rpm = rpm;
		this.codigoAbertura = codigoAbertura;
		this.numSerie = numSerie;
		this.localFisico = localFisico;
		this.mqSSM = mqSSM;
		this.lado = lado;
		this.titulo = titulo;
		this.hrTrabDia = hrTrabDia;
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

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Integer getNumFusos() {
		return numFusos;
	}

	public void setNumFusos(Integer numFusos) {
		this.numFusos = numFusos;
	}

	public Integer getRpm() {
		return rpm;
	}

	public void setRpm(Integer rpm) {
		this.rpm = rpm;
	}

	public String getCodigoAbertura() {
		return codigoAbertura;
	}

	public void setCodigoAbertura(String codigoAbertura) {
		this.codigoAbertura = codigoAbertura;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getLocalFisico() {
		return localFisico;
	}

	public void setLocalFisico(String localFisico) {
		this.localFisico = localFisico;
	}

	public String getMqSSM() {
		return mqSSM;
	}

	public void setMqSSM(String mqSSM) {
		this.mqSSM = mqSSM;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public Double getTitulo() {
		return titulo;
	}

	public void setTitulo(Double titulo) {
		this.titulo = titulo;
	}

	public String getHrTrabDia() {
		return hrTrabDia;
	}

	public void setHrTrabDia(String hrTrabDia) {
		this.hrTrabDia = hrTrabDia;
	}
	 
	

	 
	

}
