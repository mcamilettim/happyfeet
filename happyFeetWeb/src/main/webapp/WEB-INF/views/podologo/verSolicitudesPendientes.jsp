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
	   
	    <title>Historial Paciente</title>
	    
	    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${contextPath}/resources/css/jquery-ui.css">
		<script src="${contextPath}/resources/js/jquery-ui.js"></script>
		<script src="${contextPath}/resources/js/calendario.js"></script>
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
			Bienvenido podologo ${podologo.nombres}<br>
			<a href="${contextPath}/login?logout">Cerrar Sesión</a>			
		</div>
		<form method="POST" action="buscarSolicitudes">
			Buscar Por Fecha <br> 
		
		<input type="text" id="datePicker" name="fechaBusqueda" placeholder="Buscar"/><br/>
		<input type="submit" value="Buscar"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>	
		
		<div>
		${mensaje}
			<table>
				
				<c:if test="${not empty solicitudes}">
				    <tr>
						<td>Fecha-Hora Atencion</td><td>Patologia tratada</td><td>Paciente</td><td>Comuna</td><td>Monto Cancelado</td><td>Detalle</td>
					</tr>
					<c:forEach items="${solicitudes}" var="solicitud">
					<tr>
						<td> ${solicitud.horario.fecha}-${solicitud.horario.hora}</td>
						<td> ${solicitud.patologia.nombre}</td>
						<td> ${solicitud.paciente.nombres}</td>
						<td> ${solicitud.paciente.ubicacion.comuna.nombre}</td>	
						<td> ${solicitud.presupuesto.total}</td>					
						<td> <a href="${contextPath}/podologo/detalleSolicitud?id=${solicitud.id}">Ver</a></td>			   
				    </tr>
				</c:forEach>
				</c:if>
				<c:if test="${not empty solicitudesEncontradas}">
				      <tr>
						<td>Fecha-Hora Atencion</td><td>Patologia tratada</td><td>Paciente</td><td>Comuna</td><td>Monto Cancelado</td><td>Detalle</td><td>Atendida</td>
					</tr>
					<c:forEach items="${solicitudesEncontradas}" var="solicitud">
					<tr>
						<td> ${solicitud.horario.fecha}-${solicitud.horario.hora}</td>
						<td> ${solicitud.patologia.nombre}</td>
						<td> ${solicitud.paciente.nombres}</td>
						<td> ${solicitud.ubicacionLlegada.comuna.nombre}</td>	
						<td> ${solicitud.presupuesto.total}</td>					
						<td><a href="${contextPath}/podologo/detalleSolicitud?id=${solicitud.id}">Ver</a></td>		
						<td><a href="${contexPath}/podologo/detalleSolicitudAtendida?id=${solicitud.id}">Atendida</a></td>	   
				    </tr>
				</c:forEach>
				</c:if>
				
			</table>
		</div>
		<a href="${contextPath}/podologo/index">Volver</a>
	</body>
</html>
