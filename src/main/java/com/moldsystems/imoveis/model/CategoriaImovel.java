package com.moldsystems.imoveis.model;

public enum CategoriaImovel {

    CASA("CASA"),
    APARTAMENTO("APARTAMENTO"),
    TERRENO("TERRENO");
	
    private String descricao;
    
    CategoriaImovel(String descricao){
    	this.descricao = descricao;
    }
    
    public String getDescricao() {
    	return descricao;
    }
}
