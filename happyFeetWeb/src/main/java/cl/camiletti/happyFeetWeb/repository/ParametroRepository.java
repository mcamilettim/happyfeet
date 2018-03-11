package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Parametro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParametroRepository extends JpaRepository<Parametro, Long> {
	  <S extends Parametro> S save(Parametro parametro);
	  Parametro findById(int id);
	  List<Parametro> findAll();	 	
	  void delete(Parametro parametro);	
	  Parametro findByValor(String valor);
	  List<Parametro> findByNumero(int numero);
}
