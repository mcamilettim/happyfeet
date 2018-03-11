package cl.camiletti.happyFeetWeb.repository;

import cl.camiletti.happyFeetWeb.model.Presupuesto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoRepository extends JpaRepository<Presupuesto, Long> {
	  <S extends Presupuesto> S save(Presupuesto presupuesto);
	  Presupuesto findById(int id);
	  List<Presupuesto> findAll();	 	
	  void delete(Presupuesto presupuesto);	 
}

