package br.com.tobe.pedido;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoControllerImpl implements PedidoController {

	@Autowired
	private PedidoService pedidoService;

	public ResponseEntity<Page<Pedido>> getAll(Pageable pageable) {
		Page<Pedido> pedidoPage = this.pedidoService.obtemTodosOsPedidos(pageable);

		return new ResponseEntity<Page<Pedido>>(pedidoPage,HttpStatus.OK);
	}
	
	public ResponseEntity<List<Pedido>> getPedidoPorNumero(@PathVariable Long numero) {

		List<Pedido> pedido = this.pedidoService.obtemPedidoPorNumero(numero);
		return new ResponseEntity<List<Pedido>>(pedido,HttpStatus.OK);
	}
	
	public ResponseEntity<Void> finalizarSeparacao(@PathVariable Long numero) throws Exception {
		
		this.pedidoService.finalizarSeparacao(numero);		
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Void> finalizarConferencia(@PathVariable Long numero) throws Exception {
		
		this.pedidoService.finalizarConferencia(numero);		
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Pedido> saveOrCretate(@RequestBody Pedido pedido) throws Exception {
		
		pedido = this.pedidoService.gravaPedido(pedido);		
		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
	}

	public ResponseEntity<Void> remove(@PathVariable Long id) {
		
		this.pedidoService.removePedido(id);		
		return ResponseEntity.noContent().build();
	}

}
