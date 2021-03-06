package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.AgendaRepository;

@Service
public class AgendaServiceImpl implements AgendaService{
	@Autowired
	AgendaRepository agendaRepository;

	@Override
	public void save(Agenda agenda) {
		agendaRepository.save(agenda);
	}

	@Override
	public Agenda findById(int id) {
		return agendaRepository.findById(id);
	}

	@Override
	public List<Agenda> findAll() {
		return agendaRepository.findAll();
	}

	@Override
	public void deleteById(Agenda agenda) {
		agendaRepository.delete(agenda);
	}

	@Override
	public List<Agenda> findByPaciente(Paciente paciente) {
		return agendaRepository.findByPaciente(paciente);
	}

	@Override
	public List<Agenda> findByPodologo(Podologo podologo) {
		return agendaRepository.findByPodologo(podologo);
	}

	@Override
	public List<Agenda> findByPodologoAndParamEstadoAgenda(Podologo podologo, Parametro parametro) {
		return agendaRepository.findByPodologoAndParamEstadoAgenda(podologo, parametro);
	}

	@Override
	public List<Agenda> findByPacienteAndParamEstadoAgenda(Paciente paciente, Parametro parametro) {
		 
		return agendaRepository.findByPacienteAndParamEstadoAgenda(paciente, parametro);
	}
}
