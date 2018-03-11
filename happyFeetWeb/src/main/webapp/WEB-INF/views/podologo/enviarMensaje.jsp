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
				
		Paciente: ${paciente.nombres} ${paciente.apellidos}  
		<a href="${contextPath}/podologo/perfilPaciente?rut=${paciente.rut}">Ver Perfil</a>	<br>
		
		Enviar Mensaje a:<br>
		<c:forEach items="${pacientes}" var="item">
			<a href="${contextPath}/podologo/enviarMensaje?rut=${item.rut}">${item.nombres} ${item.apellidos} </a><br>
		</c:forEach>
		
		${mensaje}
		<h2>Chat</h2>
		<div>
			<c:forEach items="${conversacion}" var="mensaje">
					<label>${mensaje.cuerpo}</label><br>
			</c:forEach>
			 <form:form method="POST" modelAttribute="mensajeForm"  action="${contextPath}/podologo/enviarMensaje?rut=${paciente.rut}">
				 <spring:bind path="cuerpo">
		        	 <div class="form-group ${status.error ? 'has-error' : ''}">          
		               <form:input type="text" path="cuerpo" ></form:input>
		               <form:errors path="cuerpo"></form:errors>
		            </div>
		 		</spring:bind>
		
   		  		<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
    		</form:form>	
		</div>		
		<a href="${contextPath}/podologo/historialPaciente?rut=${paciente.rut}">Volver</a>
	</body>
</html>
