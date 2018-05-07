package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Notificacionpodologo;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.NotificacionpodologoRepository;

@Service
public class NotificacionpodologoServiceImpl implements NotificacionpodologoService {
	@Autowired
	NotificacionpodologoRepository notificacionpodologoRepository;

	@Override
	public void save(Notificacionpodologo notificacionpodologo) {
		notificacionpodologoRepository.save(notificacionpodologo);
	}

	@Override
	public List<Notificacionpodologo> findAll() {
		return notificacionpodologoRepository.findAll();
	}

	@Override
	public List<Notificacionpodologo> findByPodologo(Podologo podologo) {
		return notificacionpodologoRepository.findByPodologo(podologo);
	}

	@Override
	public List<Notificacionpodologo> findByPodologoAndParamEstadoNotificacion(Podologo podologo, Parametro parametro) {
		return notificacionpodologoRepository.findByPodologoAndParamEstadoNotificacionOrderByIdDesc(podologo, parametro);
	}

	@Override
	public Notificacionpodologo findByIdAndPodologo(int id, Podologo podologo) {
		return notificacionpodologoRepository.findByIdAndPodologo(id, podologo);
	}

	@Override
	public List<Notificacionpodologo> findByPodologoAndParamEstadoNotificacionNotIn(Podologo podologo,List<Parametro> parametros) {
		return notificacionpodologoRepository.findByPodologoAndParamEstadoNotificacionNotInOrderByIdDesc(podologo,parametros);
	}

	 

}
