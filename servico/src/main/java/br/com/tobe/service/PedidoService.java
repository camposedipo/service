package br.com.tobe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tobe.core.model.entity.Pedido;

public interface PedidoService {
	
	Page<Pedido> obtemTodosOsPedidos(Pageable pageable);

	Pedido gravaPedido(Pedido pedido) throws Exception;

	void removePedido(Long id);

	Pedido obtemPedidoPorId(Long id);
}
