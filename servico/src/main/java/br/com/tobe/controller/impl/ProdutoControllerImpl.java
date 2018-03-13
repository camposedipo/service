package br.com.tobe.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.tobe.controller.ItensPedidoController;
import br.com.tobe.core.model.entity.ItensPedido;
import br.com.tobe.service.ItensPedidoService;

@RestController
public class ProdutoControllerImpl implements ItensPedidoController {

	@Autowired
	private ItensPedidoService itensPedidoService;

	public ResponseEntity<Page<ItensPedido>> getAll(Pageable pageable) {
		Page<ItensPedido> itensPedidoPage = this.itensPedidoService.obtemTodosOsItensPedido(pageable);

		return new ResponseEntity<Page<ItensPedido>>(itensPedidoPage,HttpStatus.OK);
	}

	public ResponseEntity<ItensPedido> saveOrCretate(@RequestBody ItensPedido itensPedido) throws Exception {
		itensPedido = this.itensPedidoService.gravaItensPedido(itensPedido);
		
		return new ResponseEntity<ItensPedido>(itensPedido,HttpStatus.OK);
	}

	public ResponseEntity<Void> remove(@PathVariable Long id) {
		this.itensPedidoService.removeItensPedido(id);
		
		return ResponseEntity.noContent().build();
	}

}
