package br.com.tobe.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteControllerImpl implements ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	public ResponseEntity<Page<Cliente>> getAll(Pageable pageable) {
	
		Page<Cliente> clientePage = this.clienteService.obtemTodosOsClientes(pageable);
		return new ResponseEntity<Page<Cliente>>(clientePage,HttpStatus.OK);
	}
	
    public ResponseEntity<Cliente> getPorId(@PathVariable Long id) {
		
		Cliente cliente = this.clienteService.getPorId(id);		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	       
	public ResponseEntity<Cliente> saveOrCretate(@RequestBody Cliente cliente) throws Exception {
		
		cliente = this.clienteService.gravaCliente(cliente);		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		
		this.clienteService.removeCliente(id);		
		return ResponseEntity.noContent().build();
	}

}
