package com.santanatextiles.cpf.dto;

public class FichaTecnicaDTO {
	
	private String idfil; 
	private String codigoItem; 
	private Double  titulo;   
	private String  tipoMaquina;
	
	public FichaTecnicaDTO() {
		
	}  
    
	public FichaTecnicaDTO(String idfil, String codigoItem, Double titulo, String tipoMaquina) {
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
	public Double getTitulo() {
		return titulo;
	}
	public void setTitulo(Double titulo) {
		this.titulo = titulo;
	}

	public String getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}
	 
	
	
	

}
