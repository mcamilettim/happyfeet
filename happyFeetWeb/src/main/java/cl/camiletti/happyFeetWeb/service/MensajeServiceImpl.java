package cl.camiletti.happyFeetWeb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.MensajeRepository;
import cl.camiletti.happyFeetWeb.util.ComparadorMensajeUtil;

@Service
public class MensajeServiceImpl implements MensajeService{
	@Autowired
	MensajeRepository mensajeRepository;
	
	@Autowired
	ComparadorMensajeUtil comparadorMensajeUtil;

	@Override
	public void save(Mensaje mensaje) {
		mensajeRepository.save(mensaje);
	}

	@Override
	public Mensaje findById(int id) {
		return mensajeRepository.findById(id);
	}

	@Override
	public List<Mensaje> findAll() {
		return mensajeRepository.findAll();
	}

	@Override
	public void deleteById(Mensaje mensaje) {
		mensajeRepository.delete(mensaje);
	}

	@Override
	public List<Mensaje> findByRutEmisor(String rutEmisor) {
		return mensajeRepository.findByEmisorRut(rutEmisor);
	}

	@Override
	public List<Mensaje> findByRutReceptor(String rutReceptor) {
		return mensajeRepository.findByReceptorRut(rutReceptor);
	}

	@Override
	public List<Mensaje> cargarConversacion(Podologo podologo, Paciente paciente) {
		List<Mensaje> mensajesEmisorPodologo=mensajeRepository.findByEmisorRut(podologo.getRut());
		List<Mensaje> mensajesEmisorPaciente=mensajeRepository.findByEmisorRut(paciente.getRut());

		ArrayList<Mensaje> iterator=new ArrayList();
		ArrayList<Mensaje> conversacion=new ArrayList();
		iterator.addAll(mensajesEmisorPaciente);
		iterator.addAll(mensajesEmisorPodologo);
			
		for (Mensaje mensaje : iterator) {
			if(mensaje.getEmisorRut().equals(podologo.getRut())&&mensaje.getReceptorRut().equals(paciente.getRut())){
				conversacion.add(mensaje);
			}
			else{
				if(mensaje.getEmisorRut().equals(paciente.getRut())&&mensaje.getReceptorRut().equals(podologo.getRut())){
					conversacion.add(mensaje);
				}
			}
		}
		
		conversacion.sort(comparadorMensajeUtil);
		return conversacion;
	}
}
