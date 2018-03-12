package br.com.tobe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tobe.core.model.entity.Carga;

public interface CargaService {
	
	Page<Carga> obtemTodosOsCargas(Pageable pageable);

	Carga gravaCarga(Carga carga) throws Exception;

	void removeCarga(Long id);

	Carga obtemCargaPorId(Long id);
}
