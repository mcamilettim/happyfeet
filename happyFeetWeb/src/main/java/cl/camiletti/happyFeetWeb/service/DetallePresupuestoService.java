package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Detallepresupuesto;
import cl.camiletti.happyFeetWeb.model.Paciente;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface DetallePresupuestoService {
	void save(Detallepresupuesto detallepresupuesto);
	Detallepresupuesto findById(int id);
	List<Detallepresupuesto> findAll();
	void deleteById(Detallepresupuesto detallepresupuesto);	
}
