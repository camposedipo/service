package br.com.tobe.endereco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/endereco")
public interface EnderecoController {

	@GetMapping("/all")
	public ResponseEntity<Page<Endereco>> getAll(Pageable pageable);
	
	@GetMapping("/getPorId{id}")
	public ResponseEntity<Endereco> getPorId(@PathVariable Long id);

	@PostMapping("/save-or-create")
	public ResponseEntity<Endereco> saveOrCretate(@RequestBody Endereco endereco) throws Exception;
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id);

}
