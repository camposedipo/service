package br.com.tobe.carga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CargaControllerImpl implements CargaController {

	@Autowired
	private CargaService cargaService;

	public ResponseEntity<Page<Carga>> getAll(Pageable pageable) {
		Page<Carga> cargaPage = this.cargaService.obtemTodosOsCargas(pageable);

		return new ResponseEntity<Page<Carga>>(cargaPage,HttpStatus.OK);
	}

	public ResponseEntity<Carga> saveOrCretate(@RequestBody Carga carga) throws Exception {
		carga = this.cargaService.gravaCarga(carga);
		
		return new ResponseEntity<Carga>(carga,HttpStatus.OK);
	}

	public ResponseEntity<Void> remove(@PathVariable Long id) {
		this.cargaService.removeCarga(id);
		
		return ResponseEntity.noContent().build();
	}

}
