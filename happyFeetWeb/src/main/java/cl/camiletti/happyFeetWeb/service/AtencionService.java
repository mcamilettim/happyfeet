package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Atencion;
import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface AtencionService {
	void save(Atencion atencion);
	Atencion findById(int id);
	Atencion findByAgenda(Agenda agenda);
	Atencion findByEvaluacion(Evaluacion evaluacion);
	List<Atencion> findAll();
	void deleteById(Atencion atencion);
	 
	List<Atencion> findByAgenda(Paciente paciente,Podologo podologo);
}
