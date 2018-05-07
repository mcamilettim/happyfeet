package cl.camiletti.happyFeetWeb.service;

import java.util.List;

import cl.camiletti.happyFeetWeb.model.Notificacionpodologo;
import cl.camiletti.happyFeetWeb.model.Parametro;
import cl.camiletti.happyFeetWeb.model.Podologo;

public interface NotificacionpodologoService {
	  void save(Notificacionpodologo notificacionpodologo);
	  List<Notificacionpodologo> findAll();	 
	  List<Notificacionpodologo> findByPodologo(Podologo podologo);	 
	  Notificacionpodologo findByIdAndPodologo(int id,Podologo podologo);	 
	  List<Notificacionpodologo> findByPodologoAndParamEstadoNotificacion(Podologo podologo,Parametro parametro);	
	  List<Notificacionpodologo> findByPodologoAndParamEstadoNotificacionNotIn(Podologo podologo,List<Parametro> parametros); 
	  
}
