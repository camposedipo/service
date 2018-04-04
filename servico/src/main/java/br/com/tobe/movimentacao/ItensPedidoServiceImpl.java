package br.com.tobe.movimentacao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItensPedidoServiceImpl implements ItensPedidoService {

	@Autowired
	ItensPedidoRepository itensPedidoRepository;
	
    private EntityManager gerenciador;
	
	public ItensPedidoServiceImpl(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	@Override	
	public Page<ItensPedido> obtemTodosOsItensPedido(Pageable pageable) {
		
		Page<ItensPedido> itensPedido = this.itensPedidoRepository.findAll(pageable);
		return itensPedido; 
	}
	
	@Override	
	public List<ItensPedido> obterItensPorPedido(Long numero) {			
	
		return gerenciador.createQuery("FROM ItensPedido t where t.pedido_id = :pedido_id")
				          .setParameter("pedido_id", numero).getResultList();
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
