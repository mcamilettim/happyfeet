package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.model.Cuestionariopaciente;
import cl.camiletti.happyFeetWeb.model.Cuestionariopodologo;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface CuestionariopodologoService {
	void save(Cuestionariopodologo cuestionariopodologo);

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
