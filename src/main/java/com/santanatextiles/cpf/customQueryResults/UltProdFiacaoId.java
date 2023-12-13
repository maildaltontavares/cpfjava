package com.santanatextiles.cpf.customQueryResults;

import java.io.Serializable;
import java.util.Objects;

public class UltProdFiacaoId  implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private String IDFIL;
	private String codigoMaquina;
	
	public UltProdFiacaoId() {
		
	}

	public UltProdFiacaoId(String iDFIL, String codigoMaquina) {
		super();
		IDFIL = iDFIL;
		this.codigoMaquina = codigoMaquina;
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
		UltProdFiacaoId other = (UltProdFiacaoId) obj;
		return Objects.equals(IDFIL, other.IDFIL) && Objects.equals(codigoMaquina, other.codigoMaquina);
	}
	 
	
	
	
	
	
	

}
