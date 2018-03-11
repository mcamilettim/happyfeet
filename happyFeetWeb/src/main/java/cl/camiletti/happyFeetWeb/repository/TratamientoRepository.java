package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Tratamiento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
	  <S extends Tratamiento> S save(Tratamiento tratamiento);
	  Tratamiento findById(int id);
	  List<Tratamiento> findAll();	 	
	  void delete(Tratamiento tratamiento);	 
}

