package br.com.tobe.pedido;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
    private EntityManager gerenciador;
	
	public PedidoServiceImpl(EntityManager gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	@Override	
	public Page<Pedido> obtemTodosOsPedidos(Pageable pageable) {
		
		Page<Pedido> pedidos = this.pedidoRepository.findByOrderByPosicaoDesc(pageable);
		return pedidos; 
	}
	
	@Override	
	public List<Pedido> obtemPedidoPorNumero(Long numero) {			
		
		return gerenciador.createQuery("FROM Pedido t where t.numero = :numero")
				          .setParameter("numero", numero).getResultList();
	}

	@Override
	@Transactional
	public Pedido gravaPedido(Pedido pedido) {
		
		pedido = this.pedidoRepository.save(pedido);
		return pedido;
		
	}
	
	@Override
	@Transactional
	public void finalizarSeparacao(Long numero) {		
		
		Query query = gerenciador.
				        createQuery("update Pedido            " +
				        		    "   set posicao = 'F'     " +
				        		    "     , separado = 'S'    " +
				        		    "     , separador_id = 1  " +
				        		    "     , dtfim = :dtfim    " +
		                        	" where numero = :numero  ");
		
		query.setParameter("dtfim", new Date());
		query.setParameter("numero", numero);        
        query.executeUpdate();
	}
	
	@Override
	@Transactional
	public void finalizarConferencia(Long numero) {		
		
		Query query = gerenciador.
		        createQuery("update Pedido            " +
		        		    "   set conferido = 'S'   " +		        		    		        		    
                        	" where numero = :numero  ");
        
		query.setParameter("numero", numero);        
		query.executeUpdate();
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
