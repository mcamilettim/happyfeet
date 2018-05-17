package cl.camiletti.happyFeetWeb.util;

public interface Parametros {

	int ESTADO_AGENDA_ACEPTADA = 0;
	int ESTADO_AGENDA_PENDIENTE = 1;
	int ESTADO_HORARIO_DISPONIBLE = 2;
	int ESTADO_HORARIO_TOMADO = 3;
	int ESTADO_MENSAJE_VISTO = 4;
	int ESTADO_MENSAJE_NO_VISTO = 5;
	int ESTADO_SEXO_M = 6;
	int ESTADO_SEXO_F = 7;
	int ESTADO_PACIENTE_ACTIVO = 8;
	int ESTADO_PACIENTE_INACTIVO = 9;
	int ESTADO_PODOLOGO_ACTIVO = 10;
	int ESTADO_PODOLOGO_INACTIVO = 11;
	int ESTADO_SOLICITUD_PENDIENTE = 12;
	int ESTADO_SOLICITUD_ACEPTADA = 13;
	int ESTADO_SOLICITUD_RECHAZADA = 14;
	int ESTADO_TIPO_USUARIO_ADMIN = 15;
	int ESTADO_TIPO_USUARIO_PODOLOGO = 16;
	int ESTADO_TIPO_USUARIO_PACIENTE = 17;
	int ESTADO_CUESTIONARIO_RESUELTO = 18;
	int ESTADO_CUESTIONARIO_PENDIENTE = 19;
	int ESTADO_DESCUENTO_DISPONIBLE = 20;
	int ESTADO_DESCUENTO_NO_DISPONIBLE = 21;
	
	
	int ESTADO_AGENDA=11;
	int ESTADO_HORARIO=22;
	int ESTADO_MENSAJE=33;
	int ESTADO_SEXO=44;
	int ESTADO_PACIENTE=55;
	int ESTADO_PODOLOGO=66;
	int ESTADO_SOLICITUD=77;
 
	String ESTADO_TIPO_CUESTIONARIO_PODOLOGO="podologo";
	String ESTADO_TIPO_CUESTIONARIO_PACIENTE="paciente";
}
