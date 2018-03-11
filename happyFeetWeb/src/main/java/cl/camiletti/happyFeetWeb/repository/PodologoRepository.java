package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Podologo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PodologoRepository extends JpaRepository<Podologo, Long> {
	  <S extends Podologo> S save(Podologo podologo);
	  Podologo findByRut(String rut);
	  List<Podologo> findAll();	 	
	  void delete(Podologo podologo);	
	  Podologo findByEmail(String email);
}

