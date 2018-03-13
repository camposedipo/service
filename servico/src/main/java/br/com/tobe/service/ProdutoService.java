package br.com.tobe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tobe.core.model.entity.Produto;

public interface ProdutoService {
	
	Page<Produto> obtemTodosOsProduto(Pageable pageable);

	Produto gravaItensPedido(Produto produto) throws Exception;

	void removeProduto(Long id);

	Produto obtemProdutoPorId(Long id);
}
