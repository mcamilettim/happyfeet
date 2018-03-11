package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	  <S extends Usuario> S save(Usuario usuario);
	  Usuario findById(int id);
	  List<Usuario> findAll();	 	
	  void delete(Usuario usuario);	 
	  Usuario findByEmail(String email);
}

