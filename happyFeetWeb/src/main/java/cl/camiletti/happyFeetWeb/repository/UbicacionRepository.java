package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Comuna;
import cl.camiletti.happyFeetWeb.model.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
	  <S extends Ubicacion> S save(Ubicacion ubicacion);
	  Ubicacion findById(int id);
	  List<Ubicacion> findAll();	 	
	  void delete(Ubicacion ubicacion);	 
	  List<Ubicacion> findByNombre(String nombre);
	  List<Ubicacion> findByComuna(Comuna comuna);
}

