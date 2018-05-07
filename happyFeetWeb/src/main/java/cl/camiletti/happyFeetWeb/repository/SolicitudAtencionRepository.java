package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Horario;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.model.Solicitudatencion;

public interface SolicitudAtencionRepository extends JpaRepository<Solicitudatencion, Long> {
	<S extends Solicitudatencion> S save(Solicitudatencion solicitudAtencion);

	Solicitudatencion findById(int id);

	Solicitudatencion findByHorario(Horario horario);

	List<Solicitudatencion> findAll();

	List<Solicitudatencion> findByPaciente(Paciente paciente);

	void delete(Solicitudatencion solicitudAtencion);

	List<Solicitudatencion> findByPodologo(Podologo podologo);

	List<Solicitudatencion> findByParamEstadoSolicitudAtencionAndPodologoOrderByIdDesc(Parametro parametro, Podologo podologo);

	List<Solicitudatencion> findByPodologoAndParamEstadoSolicitudAtencionNotInOrderByIdDesc(Podologo podologo,
			List<Parametro> parametros);
}
