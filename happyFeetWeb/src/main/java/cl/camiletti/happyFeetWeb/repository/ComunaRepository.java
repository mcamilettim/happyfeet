package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Comuna;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunaRepository extends JpaRepository<Comuna, Long> {
	  <S extends Comuna> S save(Comuna comuna);
	  Comuna findById(int id);
	  List<Comuna> findAll();	 	
	  void delete(Comuna comuna);	 
}

