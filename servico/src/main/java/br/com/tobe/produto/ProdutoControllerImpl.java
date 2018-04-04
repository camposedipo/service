package br.com.tobe.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoControllerImpl implements ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	public ResponseEntity<Page<Produto>> getAll(Pageable pageable) {
		
		Page<Produto> produtoPage = this.produtoService.obtemTodosOsProduto(pageable);
		return new ResponseEntity<Page<Produto>>(produtoPage,HttpStatus.OK);
	}
	
    public ResponseEntity<Produto> getPorId(@PathVariable Long id) {
		
		Produto produto = this.produtoService.obterPorId(id);
		return new ResponseEntity<Produto>(produto,HttpStatus.OK);
	}

	public ResponseEntity<Produto> saveOrCretate(@RequestBody Produto produto) throws Exception {
		
		produto = this.produtoService.gravaProduto(produto);		
		return new ResponseEntity<Produto>(produto,HttpStatus.OK);
	}

	public ResponseEntity<Void> remove(@PathVariable Long id) {

		this.produtoService.removeProduto(id);		
		return ResponseEntity.noContent().build();
	}

}
