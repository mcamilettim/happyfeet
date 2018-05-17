package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.model.Cuestionariopodologo;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.CuestionariopodologoRepository;

@Service
public class CuestionariopodologoServiceImpl implements CuestionariopodologoService {
	@Autowired
	CuestionariopodologoRepository cuestionariopodologoRepository;

	@Override
	public void save(Cuestionariopodologo cuestionariopodologo) {
		cuestionariopodologoRepository.save(cuestionariopodologo);
	}

	@Override
	public Cuestionariopodologo findById(int id) {
		return cuestionariopodologoRepository.findById(id);
	}

	@Override
	public List<Cuestionariopodologo> findByCuestionario(Cuestionario cuestionario) {
		return cuestionariopodologoRepository.findByCuestionario(cuestionario);
	}

	@Override
	public Cuestionariopodologo findByIdAndParamEstadoCuestionarioAndParamEstadoDescuento(int id,
			Parametro estadoCuestionario, Parametro estadoDescuento) {
		return cuestionariopodologoRepository.findByIdAndParamEstadoCuestionarioAndParamEstadoDescuento(id,
				estadoCuestionario, estadoDescuento);
	}

	@Override
	public List<Cuestionariopodologo> findAll() {
		return cuestionariopodologoRepository.findAll();
	}

	@Override
	public void deleteById(Cuestionariopodologo cuestionariopodologo) {
		cuestionariopodologoRepository.deleteById(cuestionariopodologo);
	}

	@Override
	public List<Cuestionariopodologo> findByPodologo(Podologo podologo) {
		return cuestionariopodologoRepository.findByPodologo(podologo);
	}

	@Override
	public List<Cuestionariopodologo> findByPodologoAndParamEstadoCuestionarioIn(Podologo podologo,
			List<Parametro> parametros) {
		return cuestionariopodologoRepository.findByPodologoAndParamEstadoCuestionarioIn(podologo, parametros);
	}

	@Override
	public List<Cuestionariopodologo> findByCuestionarioAndParamEstadoCuestionario(Cuestionario cuestionario,
			Parametro parametro) {
		return cuestionariopodologoRepository.findByCuestionarioAndParamEstadoCuestionario(cuestionario, parametro);
	}

	@Override
	public List<Cuestionariopodologo> findByPodologoAndParamEstadoCuestionarioAndParamEstadoDescuento(Podologo podologo,
			Parametro estadoCuestionario, Parametro estadoDescuento) {
		return cuestionariopodologoRepository.findByPodologoAndParamEstadoCuestionarioAndParamEstadoDescuento(podologo,
				estadoCuestionario, estadoDescuento);
	}

}
