package com.santanatextiles.cpf.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ProducaoFiacaoId implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private String   idfil;   	
	private String   codigoMaquina;
	private Date     dataProducao;  
	private String   turno; 
	private Integer   horaInicio	;
	private String   lado;
	private Integer idSSM;
	
	public ProducaoFiacaoId() {
		
	}

	public ProducaoFiacaoId(String idfil, String codigoMaquina, Date dataProducao, String turno, Integer horaInicio,
			String lado, Integer idSSM) {
		super();
		this.idfil = idfil;
		this.codigoMaquina = codigoMaquina;
		this.dataProducao = dataProducao;
		this.turno = turno;
		this.horaInicio = horaInicio;
		this.lado = lado;
		this.idSSM = idSSM;
	}
	
	
	
	

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getCodigoMaquina() {
		return codigoMaquina;
	}

	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}

	public Date getDataProducao() {
		return dataProducao;
	}

	public void setDataProducao(Date dataProducao) {
		this.dataProducao = dataProducao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public Integer getIdSSM() {
		return idSSM;
	}

	public void setIdSSM(Integer idSSM) {
		this.idSSM = idSSM;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoMaquina, dataProducao, horaInicio, idSSM, idfil, lado, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProducaoFiacaoId other = (ProducaoFiacaoId) obj;
		return Objects.equals(codigoMaquina, other.codigoMaquina) && Objects.equals(dataProducao, other.dataProducao)
				&& Objects.equals(horaInicio, other.horaInicio) && Objects.equals(idSSM, other.idSSM)
				&& Objects.equals(idfil, other.idfil) && Objects.equals(lado, other.lado)
				&& Objects.equals(turno, other.turno);
	}
	
	
	
	
	
	
	
/*
	public ProducaoFiacaoId(String idfil, String codigoMaquina, Date dataProducao, String turno, Integer horaInicio,
			String lado) {
		super();
		this.idfil = idfil;
		this.codigoMaquina = codigoMaquina;
		this.dataProducao = dataProducao;
		this.turno = turno;
		this.horaInicio = horaInicio;
		this.lado = lado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoMaquina, dataProducao, horaInicio, idfil, lado, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProducaoFiacaoId other = (ProducaoFiacaoId) obj;
		return Objects.equals(codigoMaquina, other.codigoMaquina) && Objects.equals(dataProducao, other.dataProducao)
				&& Objects.equals(horaInicio, other.horaInicio) && Objects.equals(idfil, other.idfil)
				&& Objects.equals(lado, other.lado) && Objects.equals(turno, other.turno);
	}
	
	
	*/

	 
	
 

 
	

}
