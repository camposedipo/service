package br.com.tobe.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoControllerImpl implements EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	public ResponseEntity<Page<Endereco>> getAll(Pageable pageable) {
	
		Page<Endereco> enderecoPage = this.enderecoService.obtemTodosOsEnderecos(pageable);
		return new ResponseEntity<Page<Endereco>>(enderecoPage,HttpStatus.OK);
	}
	
    public ResponseEntity<Endereco> getPorId(@PathVariable Long id) {
		
		Endereco endereco = this.enderecoService.getPorId(id);		
		return new ResponseEntity<Endereco>(endereco,HttpStatus.OK);
	}
	       
	public ResponseEntity<Endereco> saveOrCretate(@RequestBody Endereco endereco) throws Exception {
		
		endereco = this.enderecoService.gravaEndereco(endereco);		
		return new ResponseEntity<Endereco>(endereco,HttpStatus.OK);
	}
	
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		
		this.enderecoService.removeEndereco(id);		
		return ResponseEntity.noContent().build();
	}

}
