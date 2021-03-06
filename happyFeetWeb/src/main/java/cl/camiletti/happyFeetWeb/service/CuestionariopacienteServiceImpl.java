package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Cuestionario;
import cl.camiletti.happyFeetWeb.model.Cuestionariopaciente;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.repository.CuestionariopacienteRepository;

@Service
public class CuestionariopacienteServiceImpl implements CuestionariopacienteService {
	@Autowired
	CuestionariopacienteRepository cuestionariopacienteRepository;

	@Override
	public void save(Cuestionariopaciente cuestionariopaciente) {
		cuestionariopacienteRepository.save(cuestionariopaciente);

	}

	@Override
	public Cuestionariopaciente findById(int id) {
		// TODO Auto-generated method stub
		return cuestionariopacienteRepository.findById(id);
	}

	@Override
	public List<Cuestionariopaciente> findAll() {
		// TODO Auto-generated method stub
		return cuestionariopacienteRepository.findAll();
	}

	@Override
	public void deleteById(Cuestionariopaciente cuestionariopaciente) {
		cuestionariopacienteRepository.delete(cuestionariopaciente);

	}

	@Override
	public List<Cuestionariopaciente> findByPaciente(Paciente paciente) {

		return cuestionariopacienteRepository.findByPaciente(paciente);
	}

	@Override
	public List<Cuestionariopaciente> findByPacienteAndParamEstadoCuestionarioIn(Paciente paciente,
			List<Parametro> parametros) {
		return cuestionariopacienteRepository.findByPacienteAndParamEstadoCuestionarioIn(paciente, parametros);
	}

	@Override
	public   List<Cuestionariopaciente> findByPacienteAndParamEstadoCuestionarioAndParamEstadoDescuento(
			Paciente paciente, Parametro estadoCuestionario, Parametro estadoDescuento) {
		return cuestionariopacienteRepository.findByPacienteAndParamEstadoCuestionarioAndParamEstadoDescuento(
				paciente, estadoCuestionario, estadoDescuento);
	}

	@Override
	public Cuestionariopaciente findByIdAndParamEstadoCuestionarioAndParamEstadoDescuento(int id,
			Parametro estadoCuestionario, Parametro estadoDescuento) {
		return cuestionariopacienteRepository.findByIdAndParamEstadoCuestionarioAndParamEstadoDescuento(id, estadoCuestionario, estadoDescuento);
	}

	@Override
	public List<Cuestionariopaciente> findByCuestionario(Cuestionario cuestionario) {
		return cuestionariopacienteRepository.findByCuestionario(cuestionario);
	}

	@Override
	public List<Cuestionariopaciente> findByCuestionarioAndParamEstadoCuestionario(Cuestionario cuestionario,
			Parametro parametro) {
		// TODO Auto-generated method stub
		return cuestionariopacienteRepository.findByCuestionarioAndParamEstadoCuestionario(cuestionario, parametro);
	}

 

 

}
