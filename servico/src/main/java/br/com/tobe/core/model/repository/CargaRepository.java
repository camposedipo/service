package br.com.tobe.core.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tobe.core.model.entity.Carga;

public interface CargaRepository extends JpaRepository<Carga, Long> {
	
	List<Carga> findByOrderByNumeroAsc();
	
	Page<Carga> findBy(Pageable pageable);
}
