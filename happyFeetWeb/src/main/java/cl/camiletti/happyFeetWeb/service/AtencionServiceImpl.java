package cl.camiletti.happyFeetWeb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Agenda;
import cl.camiletti.happyFeetWeb.model.Atencion;
import cl.camiletti.happyFeetWeb.model.Evaluacion;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;
import cl.camiletti.happyFeetWeb.repository.AtencionRepository;

@Service
public class AtencionServiceImpl implements AtencionService{
	@Autowired
	AtencionRepository atencionRepository;
	
	@Autowired
	AgendaService agendaService;

	@Override
	public void save(Atencion atencion) {
		atencionRepository.save(atencion);
	}

	@Override
	public Atencion findById(int id) {
		return atencionRepository.findById(id);
	}

	@Override
	public List<Atencion> findAll() {
		return atencionRepository.findAll();
	}

	@Override
	public void deleteById(Atencion atencion) {
		atencionRepository.delete(atencion);
	}

	 

	@Override
	public List<Atencion> findByAgenda(Paciente paciente,Podologo podologo) {
		ArrayList<Atencion> atencions=new ArrayList();
//		ArrayList<Agenda> agendas=(ArrayList<Agenda>) agendaService.findByPaciente(paciente);
//		for (int i = 0; i < podologo.getAgendas().size(); i++) {
//			for (int j = 0; j < agendas.size(); j++) {
//				if(podologo.getAtencions().get(i).getAgenda().getId()==agendas.get(j).getId()){
//					atencions.add(podologo.getAtencions().get(i));
//				}
//			}
//		}
		return atencions;
	}

	@Override
	public Atencion findByAgenda(Agenda agenda) {
		return atencionRepository.findByAgenda(agenda);
	}

	@Override
	public Atencion findByEvaluacion(Evaluacion evaluacion) {
		return atencionRepository.findByEvaluacion(evaluacion);
	}

 

}
