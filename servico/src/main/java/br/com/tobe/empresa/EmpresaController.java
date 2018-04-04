package br.com.tobe.empresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/empresa")
public interface EmpresaController {

	@GetMapping("/all")
	public ResponseEntity<Page<Empresa>> getAll(Pageable pageable);
	
	@GetMapping("/getPorId{id}")
	public ResponseEntity<Empresa> getPorId(@PathVariable Long id);

	@PostMapping("/save-or-create")
	public ResponseEntity<Empresa> saveOrCretate(@RequestBody Empresa empresa) throws Exception;
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id);

}
