package br.com.tobe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tobe.core.model.entity.Produto;
import br.com.tobe.core.model.repository.ProdutoRepository;
import br.com.tobe.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override	
	public Page<Produto> obtemTodosOsProduto(Pageable pageable) {
		
		Page<Produto> produto = this.produtoRepository.findAll(pageable);
		return produto; 
	}

	@Override
	public Produto gravaProduto(Produto produto) {
		
		produto = this.produtoRepository.save(produto);
		return produto;
		
	}

	@Override
	@Transactional
	public void removeProduto(Long id) {		
		
		this.produtoRepository.delete(id);
		
	}

	@Override
	public Produto obtemProdutoPorId(Long id) {
		
		Produto produto = this.produtoRepository.findOne(id);
		return produto;
		
	}

}
