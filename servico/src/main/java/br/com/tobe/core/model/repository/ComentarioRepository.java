package br.com.tobe.core.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tobe.core.model.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {

	List<Comentario> findByAutorId(Long id);
	
	List<Comentario> findByTarefaId(Long id);

}
