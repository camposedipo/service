package br.com.tobe.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tobe.core.model.entity.Carga;

@RequestMapping("/cargas")
public interface CargaController {

	@GetMapping("/all")
	public ResponseEntity<Page<Carga>> getAll(Pageable pageable);

	@PostMapping("/save-or-create")
	public ResponseEntity<Carga> saveOrCretate(@RequestBody Carga carga) throws Exception;
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id);

}
