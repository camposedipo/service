package br.com.tobe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tobe.core.model.entity.ItensPedido;
import br.com.tobe.core.model.repository.ItensPedidoRepository;
import br.com.tobe.service.ItensPedidoService;

@Service
public class VolumeServiceImpl implements ItensPedidoService {

	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	
	@Override	
	public Page<ItensPedido> obtemTodosOsItensPedido(Pageable pageable) {
		
		Page<ItensPedido> itensPedido = this.itensPedidoRepository.findAll(pageable);
		return itensPedido; 
	}

	@Override
	public ItensPedido gravaItensPedido(ItensPedido itensPedido) {
		
		itensPedido = this.itensPedidoRepository.save(itensPedido);
		return itensPedido;
		
	}

	@Override
	@Transactional
	public void removeItensPedido(Long id) {		
		
		this.itensPedidoRepository.delete(id);
		
	}

	@Override
	public ItensPedido obtemItemPedidoPorId(Long id) {
		
		ItensPedido itensPedido = this.itensPedidoRepository.findOne(id);
		return itensPedido;
		
	}

}
