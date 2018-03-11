<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="modal fade" id="solicitud" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">

<div class="modal-dialog">
    <form:form method="POST" modelAttribute="solicitudForm"  action="solicitud" enctype="multipart/form-data">
        <h2 class="form-signin-heading">Enviar Solicitud</h2>
        <spring:bind path="rutPodologo">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            Rut
                <form:input type="text" path="rutPodologo" class="form-control" autofocus="true" required="true"></form:input>
                <form:errors path="rutPodologo"></form:errors>
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
	        <spring:bind path="fechaNacimiento">
	              <div class="form-group ${status.error ? 'has-error' : ''}">
	                Fecha de Nacimiento
	                <form:input type="date" path="fechaNacimiento" id="datePicker" class="form-control" required="true"></form:input>               
	                <form:errors path="fechaNacimiento"></form:errors>           
	            </div>
	        </spring:bind>
	       	  <spring:bind path="fono">
           <div class="form-group ${status.error ? 'has-error' : ''}">
           idMinSal
               <form:input type="text" path="idMinSal" class="form-control" required="true"></form:input>
               <form:errors path="idMinSal"></form:errors>
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
	     
	     <spring:bind path="email">
           <div class="form-group ${status.error ? 'has-error' : ''}">
           Email
               <form:input type="email" path="email" class="form-control" required="true"></form:input>
               <form:errors path="email"></form:errors>
           </div>
	    </spring:bind>

           <div class="form-group ${status.error ? 'has-error' : ''}">      
               Carnet<input type="file"  class="form-control" name="carnet" value="Subir Carnet" required="true"></input>
               
           </div>	  
	    
           <div class="form-group ${status.error ? 'has-error' : ''}">      
               Titulo <input type="file" class="form-control" name="titulo" value="Subir Titulo" required="true"></input>           
           </div>
	   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>    
  </div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>