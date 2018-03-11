package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.camiletti.happyFeetWeb.model.Presupuesto;
import cl.camiletti.happyFeetWeb.repository.PresupuestoRepository;

@Service
public class PresupuestoServiceImpl implements PresupuestoService{
	@Autowired
	PresupuestoRepository presupuestoRepository;

	@Override
	public void save(Presupuesto presupuesto) {
		presupuestoRepository.save(presupuesto);
	}

	@Override
	public Presupuesto findById(int id) {
		return presupuestoRepository.findById(id);
	}

	@Override
	public List<Presupuesto> findAll() {
		return presupuestoRepository.findAll();
	}

	@Override
	public void deleteById(Presupuesto presupuesto) {
		presupuestoRepository.delete(presupuesto);
	}
}
