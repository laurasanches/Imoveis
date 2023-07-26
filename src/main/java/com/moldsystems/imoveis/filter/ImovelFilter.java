package com.moldsystems.imoveis.filter;

import java.math.BigDecimal;

import javax.persistence.Id;

import org.springframework.format.annotation.NumberFormat;

import com.moldsystems.imoveis.model.CategoriaImovel;
import com.moldsystems.imoveis.model.TipoImovel;

public class ImovelFilter {

	@Id
	private Long codigo;
	private String endereco;
	private String bairro;
	private String numero;
	private CategoriaImovel categoria;
	private TipoImovel tipo;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorMinimoVenda;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorMaximoVenda;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorMinimoLocacao;
	
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorMaximoLocacao;
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public CategoriaImovel getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaImovel categoria) {
		this.categoria = categoria;
	}
	public TipoImovel getTipo() {
		return tipo;
	}
	public void setTipo(TipoImovel tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getValorMinimoVenda() {
		return valorMinimoVenda;
	}
	public void setValorMinimoVenda(BigDecimal valorMinimoVenda) {
		this.valorMinimoVenda = valorMinimoVenda;
	}
	public BigDecimal getValorMaximoVenda() {
		return valorMaximoVenda;
	}
	public void setValorMaximoVenda(BigDecimal valorMaximoVenda) {
		this.valorMaximoVenda = valorMaximoVenda;
	}
	public BigDecimal getValorMinimoLocacao() {
		return valorMinimoLocacao;
	}
	public void setValorMinimoLocacao(BigDecimal valorMinimolocacao) {
		this.valorMinimoLocacao = valorMinimolocacao;
	}
	public BigDecimal getValorMaximoLocacao() {
		return valorMaximoLocacao;
	}
	public void setValorMaximoLocacao(BigDecimal valorMaximoLocacao) {
		this.valorMaximoLocacao = valorMaximoLocacao;
	}

	
}
