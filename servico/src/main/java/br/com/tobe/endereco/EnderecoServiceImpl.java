package br.com.tobe.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Override	
	public Page<Endereco> obtemTodosOsEnderecos(Pageable pageable) {
		
		Page<Endereco> endereco = this.enderecoRepository.findAll(pageable);
		return endereco; 
	}

	@Override
	@Transactional
	public Endereco gravaEndereco(Endereco endereco) {
		
		endereco = this.enderecoRepository.save(endereco);
		return endereco;
		
	}

	@Override
	@Transactional
	public void removeEndereco(Long id) {		
		
		this.enderecoRepository.delete(id);
		
	}

	@Override
	public Endereco getPorId(Long id) {
		
		Endereco endereco = this.enderecoRepository.findOne(id);
		return endereco;
		
	}

}
