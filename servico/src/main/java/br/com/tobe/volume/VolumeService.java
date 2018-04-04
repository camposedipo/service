package br.com.tobe.volume;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VolumeService {
	
	Page<Volume> obtemTodos(Pageable pageable);
	
	List<Volume> obterPorPedido(Long numero);

	Volume gravar(Volume itensPedido) throws Exception;

	void remover(Long id);

	Volume obtemPorId(Long id) throws Exception;
		
}
