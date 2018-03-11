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
		<form method="POST" action="buscarPacientes">
		Buscar Por 
		<select name="selectBuscar">			
			<option value="Nombre">Nombre</option>
			<option value="Rut">Rut</option>
		</select><br/>
		<input type="text" name="textBuscar" placeholder="Buscar"/><br/>
		<input type="submit" value="Buscar"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		Foto Paciente
		<img src="${contextPath}/resources/imagenes/${paciente.pathFotoPerfil}">
		<div>
		Paciente: ${paciente.nombres} ${paciente.apellidos}  
		<a href="${contextPath}/podologo/perfilPaciente?rut=${paciente.rut}">Ver Perfil</a>
		<a href="${contextPath}/podologo/enviarMensaje?rut=${paciente.rut}">Enviar Mensaje</a>
		
		${mensaje}
		<h2>Detalle del Presupuesto</h2>
		<div>
			<table border="1px">			
					<tr>
						<th> Nombre</th>
						<th> Monto</th>							
				    </tr>
				    <c:forEach items="${detallePresupuesto}" var="detalle">
						<tr>
							<td> ${detalle.item}</td>
							<td> ${detalle.monto}</td>										   
					    </tr>
				</c:forEach>
			</table>
			Total: ${presupuesto.total}		
		</div>
		</div>
		
		<div>
			<h2>Detalles Específicos</h2>
			Fecha: ${atencion.agenda.horario.fecha}<br>
			Punto de Partida: ${presupuesto.ubicacionPartida.nombre}<br>
			Punto de Llegada: ${presupuesto.ubicacionLlegada.nombre}<br>
			Tarifa Aplicada : $${presupuesto.tarifaKM} Por KM<br>
			Viaje Podologo : ${presupuesto.viajePodologo}KM<br>
			Diagnostico: ${atencion.patologia.nombre}<br>
		</div>
		<a href="${contextPath}/podologo/detalleAtencion?id=${atencion.id}">Volver</a>
	</body>
</html>
