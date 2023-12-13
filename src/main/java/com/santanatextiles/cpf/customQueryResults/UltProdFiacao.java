package com.santanatextiles.cpf.customQueryResults;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CPF.V_CPF_W_ULT_PROD",schema="PRD")
@IdClass(UltProdFiacaoId.class)

public class UltProdFiacao implements Serializable{
	
	private static final long serialVersionUID = 1L;	 
	 
	@Id
	@Column(name="IDFIL") 
	private String IDFIL;
	
	@Id
	@Column(name="D4COD")
	private  String codigoMaquina;
	
	@Column(name="D4DATA")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataProducao; 	
	
	@Column(name="D4HRFIM")
	private Integer horaFinal;
	
	@Column(name="D4TURNO")
	private String  turno;
	
	@Column(name="D4LADO")
	private String  lado;
	
	@Column(name="NHINITA")
	private Integer horaInicialTurnoA;
	
	@Column(name="NHFIMTA")
	private Integer horaFinalTurnoA;
	
	@Column(name="NHINITB")
	private Integer horaInicialTurnoB;
	
	@Column(name="NHFIMTB")
	private Integer horaFinalTurnoB;
	
	@Column(name="NHINITC")
	private Integer horaInicialTurnoC;
	
	@Column(name="NHFIMTC")
	private Integer horaFinalTurnoC;
	
	
	public UltProdFiacao() {
		
	}


	public UltProdFiacao(String iDFIL, String codigoMaquina, Date dataProducao, Integer horaFinal, String turno,
			String lado, Integer horaInicialTurnoA, Integer horaFinalTurnoA, Integer horaInicialTurnoB,
			Integer horaFinalTurnoB, Integer horaInicialTurnoC, Integer horaFinalTurnoC) {
		super();
		IDFIL = iDFIL;
		this.codigoMaquina = codigoMaquina;
		this.dataProducao = dataProducao;
		this.horaFinal = horaFinal;
		this.turno = turno;
		this.lado = lado;
		this.horaInicialTurnoA = horaInicialTurnoA;
		this.horaFinalTurnoA = horaFinalTurnoA;
		this.horaInicialTurnoB = horaInicialTurnoB;
		this.horaFinalTurnoB = horaFinalTurnoB;
		this.horaInicialTurnoC = horaInicialTurnoC;
		this.horaFinalTurnoC = horaFinalTurnoC;
	}


	public String getIDFIL() {
		return IDFIL;
	}


	public void setIDFIL(String iDFIL) {
		IDFIL = iDFIL;
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


	public Integer getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(Integer horaFinal) {
		this.horaFinal = horaFinal;
	}


	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	public String getLado() {
		return lado;
	}


	public void setLado(String lado) {
		this.lado = lado;
	}


	public Integer getHoraInicialTurnoA() {
		return horaInicialTurnoA;
	}


	public void setHoraInicialTurnoA(Integer horaInicialTurnoA) {
		this.horaInicialTurnoA = horaInicialTurnoA;
	}


	public Integer getHoraFinalTurnoA() {
		return horaFinalTurnoA;
	}


	public void setHoraFinalTurnoA(Integer horaFinalTurnoA) {
		this.horaFinalTurnoA = horaFinalTurnoA;
	}


	public Integer getHoraInicialTurnoB() {
		return horaInicialTurnoB;
	}


	public void setHoraInicialTurnoB(Integer horaInicialTurnoB) {
		this.horaInicialTurnoB = horaInicialTurnoB;
	}


	public Integer getHoraFinalTurnoB() {
		return horaFinalTurnoB;
	}


	public void setHoraFinalTurnoB(Integer horaFinalTurnoB) {
		this.horaFinalTurnoB = horaFinalTurnoB;
	}


	public Integer getHoraInicialTurnoC() {
		return horaInicialTurnoC;
	}


	public void setHoraInicialTurnoC(Integer horaInicialTurnoC) {
		this.horaInicialTurnoC = horaInicialTurnoC;
	}


	public Integer getHoraFinalTurnoC() {
		return horaFinalTurnoC;
	}


	public void setHoraFinalTurnoC(Integer horaFinalTurnoC) {
		this.horaFinalTurnoC = horaFinalTurnoC;
	}


	@Override
	public int hashCode() {
		return Objects.hash(IDFIL, codigoMaquina);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UltProdFiacao other = (UltProdFiacao) obj;
		return Objects.equals(IDFIL, other.IDFIL) && Objects.equals(codigoMaquina, other.codigoMaquina);
	}	

 
	
	
	
	
	

}
