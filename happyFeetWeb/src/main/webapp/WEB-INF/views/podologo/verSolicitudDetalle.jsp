<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">	
	    <link rel="stylesheet" href="${contextPath}/resources/css/starability-all.min.css">
	   
	   
	    <title>Historial Paciente</title>
	    
	</head>

	<body>
		<div class="container">
		    <c:if test="${pageContext.request.userPrincipal.name != null}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>        
		    </c:if>
		</div>
		<div>
			Bienvenido podologo ${podologo.nombres} <br>
			<a href="${contextPath}/login?logout">Cerrar Sesión</a>
		</div>
		<form method="POST" action="buscarSolicitudes">
			Buscar Por Fecha <br> 
		
		<input type="text" id="datePicker" name="fechaBusqueda" placeholder="Buscar"/><br/>
		<input type="submit" value="Buscar"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>	
		Foto Referencial Patologia<br>
		<img src="${contextPath}/resources/imagenes/${solicitudAtencion.patologia.foto}">
		<div>
		
		${mensaje}
		<h2>Detalle Solicitud pendiente</h2>
		<div>
			Nombre Completo: ${solicitudAtencion.paciente.nombres} ${solicitudAtencion.paciente.apellidos}    
			Fecha y hora de Atención: ${solicitudAtencion.horario.fecha} ${solicitudAtencion.horario.hora}    
			Solicitud del: ${solicitudAtencion.fechaSolicitud}<br>		
			Foto Enviada por el Paciente<br>
			<img src="${contextPath}/resources/imagenes/${solicitudAtencion.fotoPiePath}"><br>																							  
			Punto de Partida: ${solicitudAtencion.presupuesto.ubicacionPartida.nombre}<br>
			Punto de Llegada: ${solicitudAtencion.presupuesto.ubicacionLlegada.nombre}<br>
			Monto de la Atención: ${solicitudAtencion.presupuesto.total}<br>
			Diagnostico: ${solicitudAtencion.patologia.nombre}<br>			
			<a href="${contextPath}/podologo/modificarDiagnostico?id=${solicitudAtencion.id}">Modificar Diagnóstico</a><br>
			
			<form action="${contextPath}/podologo/modificarSolicitud" method="POST">	
				<select name="selectEstado">
					<option value="0">Seleccione un Estado</option>
					<c:forEach items="${estados}" var="estado">
							<option value="${estado.id}">${estado.valor}</option>
					</c:forEach>
				</select>		
				<textarea name="comentario" placeholder="Agregar Comentario"></textarea>	
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
				<input type="submit" value="Enviar">
			</form>
		</div>
		</div>
		<a href="${contextPath}/podologo/verSolicitudesPendientes">Volver</a>
	</body>
</html>
