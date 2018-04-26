package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface AgendaService {
	void save(Agenda agenda);
	Agenda findById(int id);
	List<Agenda> findAll();
	void deleteById(Agenda agenda);
	List<Agenda> findByPaciente(Paciente paciente);
	List<Agenda> findByPacienteAndParamEstadoAgenda(Paciente paciente,Parametro parametro);
	List<Agenda> findByPodologo(Podologo podologo);
	List<Agenda> findByPodologoAndParamEstadoAgenda(Podologo podologo, Parametro parametro);
}
