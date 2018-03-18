package br.com.tobe.core.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tobe.core.model.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByOrderByNumeroAsc();
	
	Page<Produto> findBy(Pageable pageable);
	
}
