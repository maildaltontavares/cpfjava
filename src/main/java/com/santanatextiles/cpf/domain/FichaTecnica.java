package com.santanatextiles.cpf.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFH8_DBF",schema="CPF")
@IdClass(FichaTecnicaId.class)
public class FichaTecnica  implements Serializable {	
	

	private static final long  serialVersionUID = 1L;
	
	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="H8COD")	
	private String codigoItem;
	
	@Column(name="H8TIT")	
	private Double  titulo;  
	
	@Column(name="H8TPMAQ")	
	private String  tipoMaquina; 	
	
	public FichaTecnica() {
		 
	} 


	public FichaTecnica(String idfil, String codigoItem, Double titulo, String tipoMaquina) {
		super();
		this.idfil = idfil;
		this.codigoItem = codigoItem;
		this.titulo = titulo;
		this.tipoMaquina = tipoMaquina;
	}






	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public Double  getTitulo() {
		return titulo;
	}

	public void setTitulo(Double  titulo) {
		this.titulo = titulo;
	}
	
	public String getTipoMaquina() {
		return tipoMaquina;
	}


	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigoItem, idfil);
	} 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FichaTecnica other = (FichaTecnica) obj;
		return Objects.equals(codigoItem, other.codigoItem) && Objects.equals(idfil, other.idfil);
	}
	
	
	
	
	
	
	

}
