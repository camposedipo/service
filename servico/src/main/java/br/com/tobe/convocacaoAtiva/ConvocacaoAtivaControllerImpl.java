package br.com.tobe.convocacaoAtiva;

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
public class ConvocacaoAtivaControllerImpl implements ConvocacaoAtivaController {

	@Autowired
	private ConvocacaoAtivaService convocacaoAtivaService;

	public ResponseEntity<Page<ConvocacaoAtiva>> getAll(Pageable pageable) {
		Page<ConvocacaoAtiva> convocacaoAtivaoPage = this.convocacaoAtivaService.obterTudoParaConvocar(pageable);

		return new ResponseEntity<Page<ConvocacaoAtiva>>(convocacaoAtivaoPage,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ConvocacaoAtiva>> getPedidoSeparar() {
		List<ConvocacaoAtiva> convocacaoAtivaList = this.convocacaoAtivaService.obterPedidoSeparar();

		return new ResponseEntity<List<ConvocacaoAtiva>>(convocacaoAtivaList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ConvocacaoAtiva> saveOrCretate(@RequestBody ConvocacaoAtiva convocacaoAtiva) throws Exception {
		convocacaoAtiva = this.convocacaoAtivaService.gravar(convocacaoAtiva);
		
		return new ResponseEntity<ConvocacaoAtiva>(convocacaoAtiva,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		this.convocacaoAtivaService.remover(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
