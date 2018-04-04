package br.com.tobe.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override	
	public Page<Cliente> obtemTodosOsClientes(Pageable pageable) {
		
		Page<Cliente> cliente = this.clienteRepository.findAll(pageable);
		return cliente; 
	}

	@Override
	@Transactional
	public Cliente gravaCliente(Cliente cliente) {
		
		cliente = this.clienteRepository.save(cliente);
		return cliente;
		
	}

	@Override
	@Transactional
	public void removeCliente(Long id) {		
		
		this.clienteRepository.delete(id);
		
	}

	@Override
	public Cliente getPorId(Long id) {
		
		Cliente cliente = this.clienteRepository.findOne(id);
		return cliente;
		
	}

}
