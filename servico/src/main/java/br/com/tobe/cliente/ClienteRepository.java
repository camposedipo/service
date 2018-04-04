package br.com.tobe.cliente;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByOrderByNumeroAsc();
	
	Page<Cliente> findBy(Pageable pageable);
	
}
