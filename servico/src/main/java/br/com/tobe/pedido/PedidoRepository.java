package br.com.tobe.pedido;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Pedido> findByOrderByNumeroAsc();
	
	Page<Pedido> findByOrderByPosicaoDesc(Pageable pageable);
	
	Page<Pedido> findBy(Pageable pageable);
}
