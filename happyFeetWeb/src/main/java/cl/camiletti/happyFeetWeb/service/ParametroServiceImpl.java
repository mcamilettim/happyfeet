package cl.camiletti.happyFeetWeb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.repository.ParametroRepository;

@Service
public class ParametroServiceImpl implements ParametroService{
	@Autowired
	ParametroRepository parametroRepository;

	@Override
	public void save(Parametro parametro) {
		parametroRepository.save(parametro);
	}

	@Override
	public Parametro findOne(int id) {
		return parametroRepository.findById(id);
	}

	@Override
	public List<Parametro> findAll() {
		return parametroRepository.findAll();
	}

	@Override
	public void deleteById(Parametro parametro) {
		parametroRepository.delete(parametro);
	}

	@Override
	public ArrayList<Parametro> findRolePodologoPaciente() {
		ArrayList<Parametro> lista=new ArrayList<Parametro>();
		lista.add(parametroRepository.findByValor("PODOLOGO"));
		lista.add(parametroRepository.findByValor("PACIENTE"));
		return lista;		
	}

	@Override
	public List<Parametro> findByNumero(int numero) {
		return parametroRepository.findByNumero(numero);
	}
	
}
