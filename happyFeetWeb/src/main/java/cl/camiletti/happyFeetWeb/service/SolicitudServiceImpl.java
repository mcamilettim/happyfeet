package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Solicitud;
import cl.camiletti.happyFeetWeb.repository.SolicitudRepository;

@Service
public class SolicitudServiceImpl implements SolicitudService{
	@Autowired
	SolicitudRepository solicitudRepository;

	@Override
	public void save(Solicitud solicitud) {
		solicitudRepository.save(solicitud);
	}

	@Override
	public Solicitud findById(int id) {
		return solicitudRepository.findById(id);
	}

	@Override
	public List<Solicitud> findAll() {
		return solicitudRepository.findAll();
	}

	@Override
	public void deleteById(Solicitud solicitud) {
		solicitudRepository.delete(solicitud);
	}

	@Override
	public List<Solicitud> findByParamEstadoSolicitudIn(List<Parametro> parametro) {
		// TODO Auto-generated method stub
		return solicitudRepository.findByParamEstadoSolicitudIn(parametro);
	}

	@Override
	public List<Solicitud> findByParamEstadoSolicitudNotIn(List<Parametro> parametro) {
		// TODO Auto-generated method stub
		return solicitudRepository.findByParamEstadoSolicitudNotIn(parametro);
	}
}
