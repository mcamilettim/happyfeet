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
			Bienvenido podologo ${podologo.nombres}<br>
			<a href="${contextPath}/login?logout">Cerrar Sesión</a>
		<div class="container">
		    <c:if test="${pageContext.request.userPrincipal.name != null}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>        
		    </c:if>
		</div>
		<div>
			<h2>Menú del podologo</h2>
		</div>
		<div>
			<a href="${contextPath}/podologo/pacientes">Pacientes</a><br>
			<a><a href="${contextPath}/podologo/verSolicitudes">Solicitudes de Atención</a></a>
			
		</div>
	</body>
</html>
