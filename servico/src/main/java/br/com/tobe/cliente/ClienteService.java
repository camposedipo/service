package br.com.tobe.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
	
	Page<Cliente> obtemTodosOsClientes(Pageable pageable);
	
	Cliente getPorId(Long id);
	
	Cliente gravaCliente(Cliente cliente) throws Exception;

	void removeCliente(Long id);
	
}
