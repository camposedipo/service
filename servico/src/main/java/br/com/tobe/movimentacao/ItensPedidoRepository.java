package br.com.tobe.movimentacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {
	
	//List<ItensPedido> findByOrderByNumeroAsc();
	
	Page<ItensPedido> findBy(Pageable pageable);
	
	//@Query("select c from pedido c order by c.posicao desc")
	//	public Page<Pedido> findByPedidosNaoFaturados();
}
