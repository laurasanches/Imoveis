package com.moldsystems.imoveis.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.moldsystems.imoveis.filter.ImovelFilter;
import com.moldsystems.imoveis.model.CategoriaImovel;
import com.moldsystems.imoveis.model.Imovel;
import com.moldsystems.imoveis.model.TipoImovel;
import com.moldsystems.imoveis.model.UFImovel;
import com.moldsystems.imoveis.repository.Imoveis;

@Service
public class CadastroImovelService {
	@Autowired
	private Imoveis imoveis;
	
	public void save(Imovel imovel) {
		try {
			imoveis.save(imovel);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException();
		}
		
	}
	
	public void delete(Long codigo) {
		imoveis.deleteById(codigo);
	}

	public List<Imovel> filtrar(ImovelFilter filtro){
		Long codigo = filtro.getCodigo();
		String endereco = filtro.getEndereco() == null ? "" : filtro.getEndereco();
		String bairro = filtro.getBairro() == null ? "" : filtro.getBairro();
		String numero = filtro.getNumero() == null? "" : filtro.getNumero();
		CategoriaImovel categoria = filtro.getCategoria();
		TipoImovel tipo = filtro.getTipo();
		BigDecimal valorMinimoVenda = filtro.getValorMinimoVenda();
		BigDecimal valorMaximoVenda = filtro.getValorMaximoVenda();
		BigDecimal valorMinimoLocacao = filtro.getValorMinimoLocacao();
		BigDecimal valorMaximoLocacao = filtro.getValorMaximoLocacao();
		
		return imoveis.filtrarPorCodigo(endereco, bairro, numero, codigo, categoria, tipo, valorMinimoVenda, valorMaximoVenda, valorMinimoLocacao, valorMaximoLocacao);
	}

	public boolean verificarEnderecoExistente(String endereco, String numero, UFImovel uf, String bairro, String cep, String cidade) {
        // Realiza a consulta no banco de dados para verificar se o endereço já existe

        // Verifica se já existe algum imóvel com o mesmo endereço, número, UF e bairro
        boolean enderecoExistente = imoveis.existsByEnderecoAndNumeroAndUfAndBairroAndCepAndCidade(endereco, numero, uf, bairro, cep, cidade);

        return enderecoExistente;
	}

}
