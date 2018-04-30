package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Mensaje;
import cl.camiletti.happyFeetWeb.model.Parametro;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
	<S extends Mensaje> S save(Mensaje mensaje);
	Mensaje findByIdAndReceptorRut(int id, String rutReceptor);
	Mensaje findById(int id);
	List<Mensaje> findAll();
	void delete(Mensaje mensaje);
	List<Mensaje> findByEmisorRutOrderByIdDesc(String rutEmisor);
	List<Mensaje> findByEmisorRutAndParamEstadoMensajeOrderByIdDesc(String rutEmisor, Parametro paramEstadoMensaje);
	List<Mensaje> findByReceptorRutAndParamEstadoMensajeOrderByIdDesc(String rutReceptor, Parametro paramEstadoMensaje);
	List<Mensaje> findByReceptorRut(String rutReceptor);
}
