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
	    <title>Menú Podologo</title>
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
		<div>
			${mensaje}
			<table>
				<tr>
					<td>Nombre Completo</td><td>Edad</td><td>Comuna</td><td>Ultima atención</td><td>Historial</td>
				</tr>
				<c:forEach items="${pacientes}" var="paciente">
					<tr>
						<td> ${paciente.nombres}  ${paciente.apellidos}</td>
						<td> ${paciente.edad}</td>
						<td> ${paciente.ubicacion.comuna.nombre}</td>	
						<td> ${paciente.fechaUltimaAtencion}</td>
						<td> <a href="${contextPath}/podologo/historialPaciente?rut=${paciente.rut}">Ver</a></td>			   
				    </tr>
				</c:forEach>
			</table>
		</div>
		<a href="${contextPath}/podologo/index">Volver</a>
	</body>
</html>
