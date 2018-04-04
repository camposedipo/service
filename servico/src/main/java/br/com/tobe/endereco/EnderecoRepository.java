package br.com.tobe.endereco;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	List<Endereco> findByOrderByNumeroAsc();
	
	Page<Endereco> findBy(Pageable pageable);
	
}
