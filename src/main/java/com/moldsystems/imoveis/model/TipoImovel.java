package com.moldsystems.imoveis.model;

public enum TipoImovel {
    LOCACAO("LOCACAO"),
    VENDA("VENDA"),
    AMBOS("AMBOS");
	
    private String descricao;
    
    TipoImovel(String descricao){
    	this.descricao = descricao;
    }
    
    public String getDescricao() {
    	return descricao;
    }
}
