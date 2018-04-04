package br.com.tobe.endereco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnderecoService {
	
	Page<Endereco> obtemTodosOsEnderecos(Pageable pageable);
	
	Endereco getPorId(Long id);
	
	Endereco gravaEndereco(Endereco endereco) throws Exception;

	void removeEndereco(Long id);
	
}
