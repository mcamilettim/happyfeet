package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Paciente;

public interface AgendaService {
	void save(Agenda agenda);
	Agenda findById(int id);
	List<Agenda> findAll();
	void deleteById(Agenda agenda);
	List<Agenda> findByPaciente(Paciente paciente);
}
