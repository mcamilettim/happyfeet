package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.model.Cuestionariopaciente;
import cl.camiletti.happyFeetWeb.model.Cuestionariopodologo;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface CuestionariopodologoRepository extends JpaRepository<Cuestionariopodologo, Long> {
	<S extends Cuestionariopodologo> S save(Cuestionariopodologo cuestionariopodologo);

	Cuestionariopodologo findById(int id);

	List<Cuestionariopodologo> findByCuestionario(Cuestionario cuestionario);

	Cuestionariopodologo findByIdAndParamEstadoCuestionarioAndParamEstadoDescuento(int id, Parametro estadoCuestionario,
			Parametro estadoDescuento);

	List<Cuestionariopodologo> findAll();

	void deleteById(Cuestionariopodologo cuestionariopodologo);

	List<Cuestionariopodologo> findByPodologo(Podologo podologo);

	List<Cuestionariopodologo> findByPodologoAndParamEstadoCuestionarioIn(Podologo podologo,
			List<Parametro> parametros);

	List<Cuestionariopodologo> findByCuestionarioAndParamEstadoCuestionario(Cuestionario cuestionario,
			Parametro parametro);

	List<Cuestionariopodologo> findByPodologoAndParamEstadoCuestionarioAndParamEstadoDescuento(Podologo podologo,
			Parametro estadoCuestionario, Parametro estadoDescuento);

}
