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
		<h2>Detalle Atención</h2>
		<div>
			Nombre Completo: ${paciente.nombres} ${paciente.apellidos}<br>
			Patologia tratada: ${atencion.patologia.nombre}<br>
			Fecha: ${atencion.agenda.horario.fecha}<br>
			<a href="${contextPath}/podologo/detallePresupesto">Detalle del Presupuesto $${atencion.presupuesto.total}</a><br>
			Dirección: ${atencion.ubicacion.nombre}<br>
			<a href="${contextPath}/podologo/diagnostico">Diagnostico e Indicaciones<br>
			Evaluación: 
			<fieldset class="starability-basic">
				<c:forEach begin="1" end="${atencion.evaluacion.valor}" varStatus="loop">
				  	<input type="radio" id="rate" name="rating" value="loop" />
				  	<label for="loop" title="${atencion.evaluacion.comentario}"></label>
				</c:forEach>		
			</fieldset>
			Foto Post Atención			
			<img src="${contextPath}/resources/imagenes/${atencion.agenda.fotoPie}"><br>
			<a href="${contextPath}/podologo/exportarDetalle">Exportar PDF<a/><br>		
		</div>
		</div>
		<a href="${contextPath}/podologo/historialPaciente?rut=${paciente.rut}">Volver</a>
	</body>
</html>
