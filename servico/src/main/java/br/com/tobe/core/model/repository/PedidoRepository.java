package br.com.tobe.core.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tobe.core.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Pedido> findByOrderByNumeroAsc();
	
	Page<Pedido> findByOrderByPosicaoDesc(Pageable pageable);
	
	Page<Pedido> findBy(Pageable pageable);
	
	//@Query("select c from pedido c order by c.posicao desc")
	//	public Page<Pedido> findByPedidosNaoFaturados();
}
