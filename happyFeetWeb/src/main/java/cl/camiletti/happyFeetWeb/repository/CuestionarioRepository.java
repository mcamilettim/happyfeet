package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.model.Parametro;

public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long> {
	<S extends Cuestionario> S save(Cuestionario cuestionario);

	Cuestionario findById(int id);

	List<Cuestionario> findAll();

	void delete(Cuestionario Cuestionario);

	List<Cuestionario> findByTipo(String tipo);

	List<Cuestionario> findByTipoAndParamEstadoCuestionario(String tipo,Parametro parametro);

}
