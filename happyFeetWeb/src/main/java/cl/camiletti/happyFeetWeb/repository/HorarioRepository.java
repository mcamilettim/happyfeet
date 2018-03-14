package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Podologo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
	  <S extends Horario> S save(Horario horario);
	  Horario findById(int id);
	  List<Horario> findAll();	 	
	  void delete(Horario horario);	 
	  List<Horario >findByPodologo(Podologo podologo);
	  List<Horario> findByFechaAndPodologo(String fecha, Podologo podologo);
}

