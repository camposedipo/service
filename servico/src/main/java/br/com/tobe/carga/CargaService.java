package br.com.tobe.carga;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CargaService {
	
	Page<Carga> obtemTodosOsCargas(Pageable pageable);

	Carga gravaCarga(Carga carga) throws Exception;

	void removeCarga(Long id);

	Carga obtemCargaPorId(Long id);
}
