package cl.camiletti.happyFeetWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.camiletti.happyFeetWeb.model.Notificacionpodologo;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface NotificacionpodologoRepository extends JpaRepository<Notificacionpodologo, Long> {
	  <S extends Notificacionpodologo> S save(Notificacionpodologo notificacionpodologo);
	  List<Notificacionpodologo> findAll();	 
	  Notificacionpodologo findByIdAndPodologo(int id,Podologo podologo);	
	  List<Notificacionpodologo> findByPodologo(Podologo podologo);	 
	  List<Notificacionpodologo> findByPodologoAndParamEstadoNotificacionOrderByIdDesc(Podologo podologo,Parametro parametro);	
	  List<Notificacionpodologo> findByPodologoAndParamEstadoNotificacionNotInOrderByIdDesc(Podologo podologo,List<Parametro> parametros);	
}
