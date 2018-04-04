package br.com.tobe.pedido;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PedidoService {
	
	Page<Pedido> obtemTodosOsPedidos(Pageable pageable);
	
	List<Pedido> obtemPedidoPorNumero(Long numero);	

	Pedido gravaPedido(Pedido pedido) throws Exception;
	
	void finalizarSeparacao(Long numero) throws Exception;
	
	void finalizarConferencia(Long numero) throws Exception;

	void removePedido(Long id);

	Pedido obtemPedidoPorId(Long id);
}
