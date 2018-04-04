package br.com.tobe.empresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmpresaService {
	
	Page<Empresa> obtemTodasAsEmpresas(Pageable pageable);
	
	Empresa obterPorId(Long id);

	Empresa gravaEmpresa(Empresa empresa) throws Exception;

	void removeEmpresa(Long id);
	
}
