package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Usuario;
import cl.camiletti.happyFeetWeb.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findById(int id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public void deleteById(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	@Override
	public Usuario login(Usuario usuario) {
		Usuario user = (Usuario) usuarioRepository.findByEmail(usuario.getEmail());
		if(user!=null){			
			return user;
			}
		else{
			return null;
		}
	}

	@Override
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
}
