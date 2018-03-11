package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Patologia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatologiaRepository extends JpaRepository<Patologia, Long> {
	  <S extends Patologia> S save(Patologia patologia);
	  Patologia findById(int id);
	  List<Patologia> findAll();	 	
	  void delete(Patologia patologia);	 
	  List<Patologia> findByNombreIgnoreCaseContaining(String nombre);
}

