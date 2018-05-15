package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.model.Cuestionariopaciente;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;

public interface CuestionariopacienteRepository extends JpaRepository<Cuestionariopaciente, Long> {
	<S extends Cuestionariopaciente> S save(Cuestionariopaciente cuestionariopaciente);

	Cuestionariopaciente findById(int id);
	List<Cuestionariopaciente> findAll();
	List<Cuestionariopaciente> findByCuestionario(Cuestionario cuestionario);

	void delete(Cuestionariopaciente cuestionariopaciente);

	List<Cuestionariopaciente> findByPaciente(Paciente paciente);

	List<Cuestionariopaciente> findByPacienteAndParamEstadoCuestionarioIn(Paciente paciente,
			List<Parametro> parametros);

	List<Cuestionariopaciente> findByPacienteAndParamEstadoCuestionarioAndParamEstadoDescuento(Paciente paciente,
			Parametro estadoCuestionario, Parametro estadoDescuento);

	Cuestionariopaciente findByIdAndParamEstadoCuestionarioAndParamEstadoDescuento(int id, Parametro estadoCuestionario,
			Parametro estadoDescuento);

}
