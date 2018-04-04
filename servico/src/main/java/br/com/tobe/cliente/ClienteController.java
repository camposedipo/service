package br.com.tobe.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cliente")
public interface ClienteController {

	@GetMapping("/all")
	public ResponseEntity<Page<Cliente>> getAll(Pageable pageable);
	
	@GetMapping("/getPorId{id}")
	public ResponseEntity<Cliente> getPorId(@PathVariable Long id);

	@PostMapping("/save-or-create")
	public ResponseEntity<Cliente> saveOrCretate(@RequestBody Cliente cliente) throws Exception;
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id);

}
