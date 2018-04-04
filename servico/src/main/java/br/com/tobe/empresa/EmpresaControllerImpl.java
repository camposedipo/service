package br.com.tobe.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaControllerImpl implements EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	public ResponseEntity<Page<Empresa>> getAll(Pageable pageable) {
		
		Page<Empresa> empresaPage = this.empresaService.obtemTodasAsEmpresas(pageable);
		return new ResponseEntity<Page<Empresa>>(empresaPage,HttpStatus.OK);
	}
	
    public ResponseEntity<Empresa> getPorId(@PathVariable Long id) {
		
		Empresa empresa = this.empresaService.obterPorId(id);
		return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
	}


	public ResponseEntity<Empresa> saveOrCretate(@RequestBody Empresa empresa) throws Exception {
		
		empresa = this.empresaService.gravaEmpresa(empresa);		
		return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
	}

	public ResponseEntity<Void> remove(@PathVariable Long id) {
		
		this.empresaService.removeEmpresa(id);		
		return ResponseEntity.noContent().build();
	}

}
