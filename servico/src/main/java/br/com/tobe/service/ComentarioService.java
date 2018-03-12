package br.com.tobe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tobe.core.model.entity.Comentario;

public interface ComentarioService {
	
	Page<Comentario> obtemTodosOsComentarios(Pageable pageable);
	
	Comentario gravaComentario(Comentario comentario) throws Exception;
	
	void removeComentario(Long id);
	
	Comentario obtemComentarioPorId(Long id);

}
