package br.com.tobe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tobe.core.model.entity.Volume;

public interface VolumeService {
	
	Page<Volume> obtemTodos(Pageable pageable);
	
	Volume obtemPorPedido(Long pedido_id);

	Volume gravar(Volume itensPedido) throws Exception;

	void remover(Long id);

	Volume obtemPorId(Long id) throws Exception;
		
}
