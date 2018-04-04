package br.com.tobe.usuario;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByOrderByNomeAsc();
	
	Page<Usuario> findBy(Pageable pageable);
}
