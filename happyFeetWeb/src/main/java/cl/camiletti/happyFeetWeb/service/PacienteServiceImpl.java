package cl.camiletti.happyFeetWeb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.MensajeRepository;
import cl.camiletti.happyFeetWeb.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	MensajeRepository mensajeRepository;

	@Override
	public void save(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	@Override
	public Paciente find(String rut) {
		return pacienteRepository.findByRut(rut);
	}

	@Override
	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	@Override
	public void deleteById(Paciente paciente) {
		pacienteRepository.delete(paciente);
	}

	@Override
	public Paciente findByEmail(String email) {
		return pacienteRepository.findByEmail(email);
	}

	@Override
	public List<Paciente> findByNombre(String nombre) {
		return pacienteRepository.findByNombres(nombre);
	}
}
