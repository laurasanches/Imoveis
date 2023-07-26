package com.moldsystems.imoveis.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moldsystems.imoveis.model.CategoriaImovel;
import com.moldsystems.imoveis.model.Imovel;
import com.moldsystems.imoveis.model.TipoImovel;
import com.moldsystems.imoveis.model.UFImovel;

public interface Imoveis extends JpaRepository<Imovel, Long> {

	public List<Imovel> findByCodigoAndEnderecoContainingAndBairroContainingAndNumeroContaining(Long codigo, String endereco, String bairro, String numero);

	@Query("SELECT i FROM Imovel i WHERE i.endereco LIKE %:endereco% " +
	        "AND i.bairro LIKE %:bairro% " +
	        "AND i.numero LIKE %:numero% " +
	        "AND (i.codigo = :codigo OR :codigo IS NULL)" +
			"AND (:categoria IS NULL OR i.categoria = :categoria)" +
			"AND (:tipo IS NULL OR i.tipo = :tipo)" +
	        "AND (:valorMinimoVenda IS NULL OR i.valorVenda >= :valorMinimoVenda) " +
	        "AND (:valorMaximoVenda IS NULL OR i.valorVenda <= :valorMaximoVenda) " +
	        "AND (:valorMinimoLocacao IS NULL OR i.valorLocacao >= :valorMinimoLocacao) " +
	        "AND (:valorMaximoLocacao IS NULL OR i.valorLocacao <= :valorMaximoLocacao)")

	public List<Imovel> filtrarPorCodigo(@Param("endereco") String endereco,
	                                     @Param("bairro") String bairro,
	                                     @Param("numero") String numero,
	                                     @Param("codigo") Long codigo,
										 @Param("categoria") CategoriaImovel categoria,
										 @Param("tipo") TipoImovel tipo,
	                                     @Param("valorMinimoVenda") BigDecimal valorMinimoVenda,
	                                     @Param("valorMaximoVenda") BigDecimal valorMaximoVenda,
	                                     @Param("valorMinimoLocacao") BigDecimal valorMinimoLocacao,
	                                     @Param("valorMaximoLocacao") BigDecimal valorMaximoLocacao);
	boolean existsByEnderecoAndNumeroAndUfAndBairroAndCepAndCidade(String endereco, String numero, UFImovel uf, String bairro, String cep, String cidade);

}