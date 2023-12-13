package com.santanatextiles.cpf.dto;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class TurnoDTO   implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	private String idfil;
	private String codigo;	 
	private Integer horaInicial;
	private Integer horaFinal;
	
	private Integer nHINITA;
	private Integer nHFIMTA;
	
	
	private Integer nHINITB;
	private Integer nHFIMTB;
	
	private Integer nHINITC;
	private Integer nHFIMTC;	
	
	public TurnoDTO() {
		
	}
	
	
	public TurnoDTO(String idfil, String codigo, Integer horaInicial, Integer horaFinal) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}
	
	
	
	

	public TurnoDTO(String idfil, Integer nHINITA, Integer nHFIMTA, Integer nHINITB, Integer nHFIMTB, Integer nHINITC,
			Integer nHFIMTC) {
		super();
		this.idfil = idfil;
		this.nHINITA = nHINITA;
		this.nHFIMTA = nHFIMTA;
		this.nHINITB = nHINITB;
		this.nHFIMTB = nHFIMTB;
		this.nHINITC = nHINITC;
		this.nHFIMTC = nHFIMTC;
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

	public Integer getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Integer horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Integer getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Integer horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Integer getnHINITA() {
		return nHINITA;
	}

	public void setnHINITA(Integer nHINITA) {
		this.nHINITA = nHINITA;
	}

	public Integer getnHFIMTA() {
		return nHFIMTA;
	}

	public void setnHFIMTA(Integer nHFIMTA) {
		this.nHFIMTA = nHFIMTA;
	}

	public Integer getnHINITB() {
		return nHINITB;
	}

	public void setnHINITB(Integer nHINITB) {
		this.nHINITB = nHINITB;
	}

	public Integer getnHFIMTB() {
		return nHFIMTB;
	}

	public void setnHFIMTB(Integer nHFIMTB) {
		this.nHFIMTB = nHFIMTB;
	}

	public Integer getnHINITC() {
		return nHINITC;
	}

	public void setnHINITC(Integer nHINITC) {
		this.nHINITC = nHINITC;
	}

	public Integer getnHFIMTC() {
		return nHFIMTC;
	}

	public void setnHFIMTC(Integer nHFIMTC) {
		this.nHFIMTC = nHFIMTC;
	}	
	
	
	

}
