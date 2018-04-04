package br.com.tobe.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {
	
	Page<Produto> obtemTodosOsProduto(Pageable pageable);
	
	Produto obterPorId(Long id);

	Produto gravaProduto(Produto produto) throws Exception;

	void removeProduto(Long id);
	
}
