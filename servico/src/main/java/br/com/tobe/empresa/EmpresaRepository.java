package br.com.tobe.empresa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	List<Empresa> findByOrderByNumeroAsc();
	
	Page<Empresa> findBy(Pageable pageable);
	
}
