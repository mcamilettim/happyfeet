package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
	<S extends Evaluacion> S save(Evaluacion evaluacion);

	Evaluacion findById(int id);

	List<Evaluacion> findByPodologo(Podologo podologo);

	List<Evaluacion> findByPaciente(Paciente paciente);

	List<Evaluacion> findByPacienteAndValorPodologo(Paciente paciente, int valorPodologo);

	List<Evaluacion> findAll();

	void delete(Evaluacion evaluacion);
}
