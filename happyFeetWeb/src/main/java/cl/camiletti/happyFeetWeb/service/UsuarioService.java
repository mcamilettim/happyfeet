package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Usuario;

public interface UsuarioService {
	void save(Usuario usuario);
	Usuario findById(int id);
	List<Usuario> findAll();
	void deleteById(Usuario usuario);
	Usuario login(Usuario usuario);
	Usuario findByEmail(String email);
}
