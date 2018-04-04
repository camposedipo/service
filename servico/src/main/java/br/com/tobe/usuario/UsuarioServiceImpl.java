package br.com.tobe.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Page<Usuario> obtemTodosOsUsuarios(Pageable pageable) {

		Page<Usuario> usuarios = this.usuarioRepository.findAll(pageable);
		return usuarios;

	}

	@Override
	public Usuario gravaUsuario(Usuario usuario) {
		
		usuario = this.usuarioRepository.save(usuario);
		return usuario;
	}

	@Override
	@Transactional
	public void removeUsuario(Long id) {		

		this.usuarioRepository.delete(id);
	}

	@Override
	public Usuario obtemUsuarioPorId(Long id) {
		
		Usuario usuario = this.usuarioRepository.findOne(id);
		return usuario;		
	}

}
