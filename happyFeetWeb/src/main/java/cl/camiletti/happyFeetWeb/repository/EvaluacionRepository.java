package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Evaluacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
 
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
	  <S extends Evaluacion> S save(Evaluacion evaluacion);
	  Evaluacion findById(int id);
	  List<Evaluacion>  findByRutReceptor(String rutReceptor);
	  List<Evaluacion> findAll();	 	
	  void delete(Evaluacion evaluacion);	 
}

