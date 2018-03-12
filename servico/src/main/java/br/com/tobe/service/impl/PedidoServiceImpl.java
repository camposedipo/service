package br.com.tobe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tobe.core.model.entity.Pedido;
import br.com.tobe.core.model.repository.PedidoRepository;
import br.com.tobe.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Override	
	public Page<Pedido> obtemTodosOsPedidos(Pageable pageable) {
		
		Page<Pedido> pedidos = this.pedidoRepository.findByOrderByPosicaoDesc(pageable);
		return pedidos; 
	}

	@Override
	public Pedido gravaPedido(Pedido pedido) {
		
		pedido = this.pedidoRepository.save(pedido);
		return pedido;
		
	}

	@Override
	@Transactional
	public void removePedido(Long id) {		
		
		this.pedidoRepository.delete(id);
		
	}

	@Override
	public Pedido obtemPedidoPorId(Long id) {
		
		Pedido pedido = this.pedidoRepository.findOne(id);
		return pedido;
		
	}

}
