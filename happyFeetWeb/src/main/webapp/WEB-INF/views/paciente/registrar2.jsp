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

    <title>Crear Cuenta Paciente</title>

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

    <form:form method="POST" modelAttribute="pacienteForm"  action="registrarPaciente">
        <h2 class="form-signin-heading">Registrar Paciente</h2>
        <spring:bind path="rut">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            Rut
                <form:input type="text" path="rut" class="form-control" autofocus="true" required="true"></form:input>
                <form:errors path="rut"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="nombres">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            Nombres
                <form:input type="text" path="nombres" class="form-control" required="true" ></form:input>
                <form:errors path="nombres"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="apellidos">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            Apellidos
                <form:input type="text" path="apellidos" class="form-control" required="true"></form:input>
                <form:errors path="apellidos"></form:errors>
            </div>
        </spring:bind>
        
         <spring:bind path="ubicacion">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            Dirección
                <form:input type="text" path="ubicacion.nombre" class="form-control" required="true"></form:input>
                <form:errors path="ubicacion"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="ubicacion.comuna">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            Comuna
            	<form:select path="ubicacion.comuna.id">  
				   <form:options items="${comunas}" itemLabel="nombre" itemValue="id" required="true"/>
				 </form:select>                
                <form:errors path="ubicacion"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="diabetico">
        	<div class="form-group ${status.error ? 'has-error' : ''}">
                Diabetico
                <form:checkbox path="diabetico" value="1" class="form-control"></form:checkbox>
                <form:errors path="diabetico"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="fechaNacimiento">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                Fecha de Nacimiento
                <form:input type="text" path="fechaNacimiento" id="datePicker" class="form-control" required="true"></form:input>               
                <form:errors path="fechaNacimiento"></form:errors>
            </div>
        </spring:bind>
       
    	  <spring:bind path="fono">
           <div class="form-group ${status.error ? 'has-error' : ''}">
           Telefono
               <form:input type="text" path="fono" class="form-control" required="true"></form:input>
               <form:errors path="fono"></form:errors>
           </div>
	    </spring:bind>
	    <spring:bind path="paramSexo">
	            <div class="form-group ${status.error ? 'has-error' : ''}">
	            Sexo
            	<form:select path="paramSexo.id">  
				   <form:options items="${sexos}" itemLabel="valor" itemValue="id" required="true"/>
			    </form:select>          	            
	                <form:errors path="paramSexo"></form:errors>
	            </div>
	     </spring:bind>
	     
	     <spring:bind path="fono">
           <div class="form-group ${status.error ? 'has-error' : ''}">
           Email
               <form:input type="email" path="email" class="form-control" required="true"></form:input>
               <form:errors path="email"></form:errors>
           </div>
	    </spring:bind>
	    
	    <spring:bind path="usuario">
           <div class="form-group ${status.error ? 'has-error' : ''}">
           Password
               <form:input type="password" path="usuario.password" class="form-control" required="true" ></form:input>
               <form:errors path="usuario.password"></form:errors>
           </div>
	    </spring:bind>
	    
	    <spring:bind path="usuario">
           <div class="form-group ${status.error ? 'has-error' : ''}">
           Confirmar Password
               <form:input type="password" path="usuario.passwordConfirm" class="form-control"  required="true" ></form:input>
               <form:errors path="usuario.passwordConfirm"></form:errors>
           </div>
	    </spring:bind>
		
   		 <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
    
  
</div>
<!-- /container -->

</body>
</html>
