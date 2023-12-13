package com.santanatextiles.cpf.domain;

import java.util.Objects;

public class FichaTecnicaId {

	private String idfil; 
	private String codigoItem;
	
	public FichaTecnicaId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FichaTecnicaId(String idfil, String codigoItem) {
		super();
		this.idfil = idfil;
		this.codigoItem = codigoItem;
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
		FichaTecnicaId other = (FichaTecnicaId) obj;
		return Objects.equals(codigoItem, other.codigoItem) && Objects.equals(idfil, other.idfil);
	} 	
	
	
	
	
	
	
	
	
	
	
}
