package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;
import cl.camiletti.happyFeetWeb.repository.SolicitudAtencionRepository;

@Service
public class SolicitudAtencionImpl implements SolicitudAtencionService{
	@Autowired
	SolicitudAtencionRepository solicitudAtencionRepository;

	@Override
	public void save(Solicitudatencion solicitudAtencion) {
		solicitudAtencionRepository.save(solicitudAtencion);
	}

	@Override
	public Solicitudatencion findById(int id) {
		return solicitudAtencionRepository.findById(id);
	}

	@Override
	public List<Solicitudatencion> findAll() {
		return solicitudAtencionRepository.findAll();
	}

	@Override
	public void deleteById(Solicitudatencion solicitudAtencion) {
		solicitudAtencionRepository.delete(solicitudAtencion);
	}

	@Override
	public List<Solicitudatencion> findByPodologo(Podologo podologo) {
		return solicitudAtencionRepository.findByPodologo(podologo);
	}

	@Override
	public List<Solicitudatencion> findByParamEstadoSolicitudAtencion(Parametro parametro, Podologo podologo) {
		return solicitudAtencionRepository.findByParamEstadoSolicitudAtencionAndPodologoOrderByIdDesc(parametro, podologo);
	}

	@Override
	public Solicitudatencion findByHorario(Horario horario) {
		return solicitudAtencionRepository.findByHorario(horario);
	}

	@Override
	public List<Solicitudatencion> findByPaciente(Paciente paciente) {
		return solicitudAtencionRepository.findByPaciente(paciente);
	}

	@Override
	public List<Solicitudatencion> findByPodologoAndParamEstadoSolicitudAtencionNotIn(Podologo podologo,
			List<Parametro> parametros) {
		// TODO Auto-generated method stub
		return solicitudAtencionRepository.findByPodologoAndParamEstadoSolicitudAtencionNotInOrderByIdDesc(podologo, parametros);
	}
}
