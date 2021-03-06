package br.com.tobe.carga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CargaServiceImpl implements CargaService {

	@Autowired
	CargaRepository cargaRepository;
	
	@Override	
	public Page<Carga> obtemTodosOsCargas(Pageable pageable) {
		
		Page<Carga> cargas = this.cargaRepository.findAll(pageable);
		return cargas; 
	}

	@Override
	public Carga gravaCarga(Carga carga) {
		
		carga = this.cargaRepository.save(carga);
		return carga;
		
	}

	@Override
	@Transactional
	public void removeCarga(Long id) {		
		
		this.cargaRepository.delete(id);
				
	}

	@Override
	public Carga obtemCargaPorId(Long id) {
		
		Carga carga = this.cargaRepository.findOne(id);
		return carga;
		
	}

}
