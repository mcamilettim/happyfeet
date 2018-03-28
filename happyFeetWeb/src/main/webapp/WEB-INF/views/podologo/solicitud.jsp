<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cuido mis pies - Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="${contextPath}/resources/css/jquery-ui.css" rel="stylesheet">
	<link href="${contextPath}/resources/js/bootstrap-datepicker.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" style="background-color: #286090;">
                    	<img src="${contextPath}/resources/img/logo2.png" class="img-responsive" style="width: 360px;">
                        <h1 class="panel-title" style="margin-top: -16px;"></h1>
                    </div>
                    <div class="panel-body">
                     <form:form method="POST" modelAttribute="solicitudForm"  action="solicitud" enctype="multipart/form-data">
			        <h2 class="form-signin-heading">Registro podólogo</h2>
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
		                Fecha de Nacimiento (dd/mm/yyyy)
		                <form:input type="date" path="fechaNacimiento" id="datePicker" class="form-control" required="true"></form:input>               
		                <form:errors path="fechaNacimiento"></form:errors>           
		            </div>
		        </spring:bind>
		       	  <spring:bind path="idMinSal">
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
					
			   		 <button class="btn btn-lg btn-primary btn-block" type="submit">Registro Podólogo!</button>
			   		 <br> <center><a href="${contextPath}/login">¿Ya tienes cuenta?</a></center>
			   		 <br> <center><a href="/">Volver al Home</a></center>
			    </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>
	<script src="${contextPath}/resources/js/jquery-ui.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${contextPath}/resources/dist/js/sb-admin-2.js"></script>
	<script type="text/javascript">
	$(document).ready(function () {
		$.datepicker.regional['es'] = {
				closeText : 'Cerrar',
				prevText : '<Ant',
					 nextText: 'Sig>',
				currentText : 'Hoy',
				monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
						'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre',
						'Diciembre' ],
				monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul',
						'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
				dayNames : [ 'Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves',
						'Viernes', 'Sabado' ],
				dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mie', 'Juv', 'Vie', 'Sab' ],
				dayNamesMin : [ 'Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa' ],
				weekHeader : 'Sm',
				dateFormat : 'dd/mm/yy',
				firstDay : 1,
				isRTL : false,
				showMonthAfterYear : false,
				yearSuffix : '',
				//beforeShow: function(i) { if ($('dp1').attr('readonly')) { return false; } }
			};
		$.datepicker.setDefaults($.datepicker.regional['es']);

		$("#datePicker").datepicker({
            //dateFormat: 'dd/mm/yy',
            inline: true
            //beforeShow: function(i) { if ($(i).attr('readonly')) { return false; } }
        });
	});
	
	</script>
</body>

</html>
