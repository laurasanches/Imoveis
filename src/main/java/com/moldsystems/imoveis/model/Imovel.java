package com.moldsystems.imoveis.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Imovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message="Endereço é obrigatório")
	private String endereco;
	
	@NotEmpty(message="CEP é obrigatório")
	private String cep;
	
	@NotEmpty(message="Bairro é obrigatório")
	private String bairro;
	
	@NotEmpty(message="Cidade é obrigatória")
	private String cidade;
	
	@NotEmpty(message="Número é obrigatório")
	private String numero;
	
	//@NotNull(message="Valor não pode ser nulo")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valorLocacao;
	
	//@NotNull(message="Valor não pode ser nulo")
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valorVenda;
	
	@Enumerated(EnumType.STRING)
	private UFImovel uf;
	
	@Enumerated(EnumType.STRING)
	private CategoriaImovel categoria;
	
	@Enumerated(EnumType.STRING)
	private TipoImovel tipo;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public UFImovel getUf() {
		return uf;
	}
	public void setUf(UFImovel uf) {
		this.uf = uf;
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
	public BigDecimal getValorLocacao() {
		return valorLocacao;
	}
	public void setValorLocacao(BigDecimal valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	public BigDecimal getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		return Objects.equals(codigo, other.codigo);
	}

	
}
