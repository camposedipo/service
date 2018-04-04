package br.com.tobe.pedido;

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

@RequestMapping("/pedidos")
public interface PedidoController {

	@GetMapping("/all")
	public ResponseEntity<Page<Pedido>> getAll(Pageable pageable);
	
	@GetMapping("/consultarPorNumero/{numero}")
	public ResponseEntity<List<Pedido>> getPedidoPorNumero(@PathVariable Long numero);
	
	@PostMapping("/finalizarSeparacao/{numero}")
	public ResponseEntity<Void> finalizarSeparacao(@PathVariable Long numero) throws Exception;
	
	@PostMapping("/finalizarConferencia/{numero}")
	public ResponseEntity<Void> finalizarConferencia(@PathVariable Long numero) throws Exception;
	
	@PostMapping("/save-or-create")
	public ResponseEntity<Pedido> saveOrCretate(@RequestBody Pedido pedido) throws Exception;
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id);

}
