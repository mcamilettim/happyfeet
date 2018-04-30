package cl.camiletti.happyFeetWeb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.MensajeRepository;
import cl.camiletti.happyFeetWeb.util.ComparadorMensajeUtil;
import cl.camiletti.happyFeetWeb.util.Parametros;

@Service
public class MensajeServiceImpl implements MensajeService {
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
	public List<Mensaje> findByEmisorRut(String rutEmisor) {
		return mensajeRepository.findByEmisorRutOrderByIdDesc(rutEmisor);
	}

	@Override
	public List<Mensaje> findByReceptorRut(String rutReceptor) {
		return mensajeRepository.findByReceptorRut(rutReceptor);
	}

	@Override
	public List<Mensaje> cargarConversacionPodologo(Podologo podologo, Paciente paciente) {
		List<Mensaje> mensajesEmisorPodologo = mensajeRepository.findByEmisorRutOrderByIdDesc(podologo.getRut());
		List<Mensaje> mensajesEmisorPaciente = mensajeRepository.findByEmisorRutOrderByIdDesc(paciente.getRut());

		ArrayList<Mensaje> iterator = new ArrayList<Mensaje>();
		ArrayList<Mensaje> conversacion = new ArrayList<Mensaje>();
		iterator.addAll(mensajesEmisorPaciente);
		iterator.addAll(mensajesEmisorPodologo);

		for (Mensaje mensaje : iterator) {
			if (mensaje.getEmisorRut().equals(podologo.getRut())
					&& mensaje.getReceptorRut().equals(paciente.getRut())) {
				conversacion.add(mensaje);
			} else {
				if (mensaje.getEmisorRut().equals(paciente.getRut())
						&& mensaje.getReceptorRut().equals(podologo.getRut())) {
					conversacion.add(mensaje);
				}
			}
		}

		conversacion.sort(comparadorMensajeUtil);
		return conversacion;
	}

	@Override
	public List<Mensaje> cargarConversacionPaciente(Paciente paciente, Podologo podologo) {
		List<Mensaje> mensajesEmisorPodologo = mensajeRepository.findByEmisorRutOrderByIdDesc(podologo.getRut());
		List<Mensaje> mensajesEmisorPaciente = mensajeRepository.findByEmisorRutOrderByIdDesc(paciente.getRut());

		ArrayList<Mensaje> iterator = new ArrayList<Mensaje>();
		ArrayList<Mensaje> conversacion = new ArrayList<Mensaje>();
		iterator.addAll(mensajesEmisorPodologo);
		iterator.addAll(mensajesEmisorPaciente);

		for (Mensaje mensaje : iterator) {
			if (mensaje.getEmisorRut().equals(paciente.getRut())
					&& mensaje.getReceptorRut().equals(podologo.getRut())) {
				conversacion.add(mensaje);
			} else {
				if (mensaje.getEmisorRut().equals(podologo.getRut())
						&& mensaje.getReceptorRut().equals(paciente.getRut())) {
					conversacion.add(mensaje);
				}

			}
		}

		conversacion.sort(comparadorMensajeUtil);
		return conversacion;
	}

	@Override
	public List<Mensaje> findByEmisorRutAndParamEstadoMensaje(String rutEmisor, Parametro paramEstadoMensaje) {
		return mensajeRepository.findByEmisorRutAndParamEstadoMensajeOrderByIdDesc(rutEmisor, paramEstadoMensaje);
	}

	@Override
	public List<Mensaje> findByReceptorRutAndParamEstadoMensaje(String rutReceptor, Parametro paramEstadoMensaje) {
		return mensajeRepository.findByReceptorRutAndParamEstadoMensajeOrderByIdDesc(rutReceptor, paramEstadoMensaje);
	}

	@Override
	public void updateEstadoMensajeVisto(List<Mensaje> mensajes, Parametro parametro) {
		for (Mensaje mensaje : mensajes) {
			if (mensaje.getParamEstadoMensaje().getId()==Parametros.ESTADO_MENSAJE_NO_VISTO) {
				mensaje.setParamEstadoMensaje(parametro);
				mensajeRepository.save(mensaje);
			}
		}

	}

	@Override
	public Mensaje findByIdAndPaciente(int id, Paciente paciente) { 
		return mensajeRepository.findByIdAndReceptorRut(id, paciente.getRut());
	}
}
