package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Ubicacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
	  <S extends Ubicacion> S save(Ubicacion ubicacion);
	  Ubicacion findById(int id);
	  List<Ubicacion> findAll();	 	
	  void delete(Ubicacion ubicacion);	 
	  List<Ubicacion> findByNombre(String nombre);
}

