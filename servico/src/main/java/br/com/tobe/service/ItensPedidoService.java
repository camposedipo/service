package br.com.tobe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tobe.core.model.entity.ItensPedido;

public interface ItensPedidoService {
	
	Page<ItensPedido> obtemTodosOsItensPedido(Pageable pageable);

	ItensPedido gravaItensPedido(ItensPedido itensPedido) throws Exception;

	void removeItensPedido(Long id);

	ItensPedido obtemItemPedidoPorId(Long id);
}
