package br.com.tobe.convocacaoAtiva;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/convocacaoAtiva")
public interface ConvocacaoAtivaController {

	@GetMapping("/all")
	public ResponseEntity<Page<ConvocacaoAtiva>> getAll(Pageable pageable);
	
	@GetMapping("/consultarPedidoSeparar")
	public ResponseEntity<List<ConvocacaoAtiva>> getPedidoSeparar();

	@PostMapping("/save-or-create")
	public ResponseEntity<ConvocacaoAtiva> saveOrCretate(@RequestBody ConvocacaoAtiva convocacaoAtiva) throws Exception;
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id);

}
