package br.com.tobe.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Override	
	public Page<Empresa> obtemTodasAsEmpresas(Pageable pageable) {
		
		Page<Empresa> empresa = this.empresaRepository.findAll(pageable);
		return empresa; 
	}
	
	@Override
	public Empresa obterPorId(Long id) {
		
		Empresa empresa = this.empresaRepository.findOne(id);
		return empresa;
		
	}

	@Override
	public Empresa gravaEmpresa(Empresa empresa) {
		
		empresa = this.empresaRepository.save(empresa);
		return empresa;
		
	}

	@Override
	@Transactional
	public void removeEmpresa(Long id) {		
		
		this.empresaRepository.delete(id);
		
	}

}
