package br.com.tobe.movimentacao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItensPedidoService {
	
	Page<ItensPedido> obtemTodosOsItensPedido(Pageable pageable);
	
	List<ItensPedido> obterItensPorPedido(Long numero);

	ItensPedido gravaItensPedido(ItensPedido itensPedido) throws Exception;

	void removeItensPedido(Long id);

	ItensPedido obtemItemPedidoPorId(Long id);
}
