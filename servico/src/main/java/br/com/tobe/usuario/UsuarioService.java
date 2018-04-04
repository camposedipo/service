package br.com.tobe.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
	
	Page<Usuario> obtemTodosOsUsuarios(Pageable pageable);

	Usuario gravaUsuario(Usuario usuario) throws Exception;

	void removeUsuario(Long id);

	Usuario obtemUsuarioPorId(Long id);
}
