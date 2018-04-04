package br.com.tobe.produto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByOrderByNumeroAsc();
	
	Page<Produto> findBy(Pageable pageable);
	
}
