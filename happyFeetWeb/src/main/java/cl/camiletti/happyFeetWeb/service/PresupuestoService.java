package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Presupuesto;

public interface PresupuestoService {
	void save(Presupuesto presupuesto);
	Presupuesto findById(int id);
	List<Presupuesto> findAll();
	void deleteById(Presupuesto presupuesto);
}
