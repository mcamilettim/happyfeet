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
	<link rel="apple-touch-icon" sizes="57x57" href="${contextPath}/resources/icon/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="${contextPath}/resources/icon/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="${contextPath}/resources/icon/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="${contextPath}/resources/icon/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="${contextPath}/resources/icon/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="${contextPath}/resources/icon/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="${contextPath}/resources/icon/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="${contextPath}/resources/icon/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="${contextPath}/resources/icon/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="${contextPath}/resources/icon/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="${contextPath}/resources/icon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${contextPath}/resources/icon/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${contextPath}/resources/icon/favicon-16x16.png">
	<link rel="manifest" href="/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">	
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
    <style type="text/css">
	.rut-error{
		color: red;
		font-weight: bold;
		padding: 3px 10px;
		display: inline-block;
		margin-left: 10px;
	}
	</style>
</head>
<body>
    <div class="container">
    <br>
                 <div class="panel panel-default">
                        <div class="panel-heading">
                           <strong> NOTA </strong>
                        </div>
						<div style="text-align: justify;" align="center">
    			 <p style="padding-left: 10px; padding-right: 10px;" >Estimado Paciente, por el sistema opera en las comunas de Pudahuel y Maipú (Santiago), próximamente abarcarémos más Comunas. <strong>¡ESTAMOS TRABAJANDO PARA USTED ! </strong>  </p>
    				  </div>	 
		   </div>						     
        <div class="row">
            <div class="col-md-4 col-md-offset-4" style="top: -90px;">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" style="background-color: #286090;">
                    	<img src="${contextPath}/resources/img/logo2.png" class="img-responsive" style="width: 360px;">
                        <h1 class="panel-title" style="margin-top: -16px;"></h1>
                    </div>
                    <div class="panel-body">
                    <form:form method="POST" modelAttribute="pacienteForm"  action="registrarPaciente" enctype="multipart/form-data" >
			        <h2 class="form-signin-heading">Registro de paciente</h2>
			         <spring:bind path="rut">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			              Rut
			                <form:input type="text" id="rut"  path="rut" class="form-control" autofocus="true" required="true" maxlength="10" size="10"></form:input>		           
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
			            <p id="mensajeDirecion">Dirección<p>
			                <form:input id="ubicacion" type="text" path="ubicacion.nombre" class="form-control" required="true"></form:input>
			                <form:errors path="ubicacion"></form:errors>
			            </div>
			        </spring:bind>
			        <spring:bind path="ubicacion.latitud">
			            <div class="form-group ${status.error ? 'has-error' : ''}">    
			                <form:input id="latitud" type="hidden" path="ubicacion.latitud" class="form-control" required="true"></form:input>
			                <form:errors path="ubicacion.latitud"></form:errors>
			            </div>
			        </spring:bind>
			        <spring:bind path="ubicacion.longitud">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input id="longitud" type="hidden" path="ubicacion.longitud" class="form-control" required="true"></form:input>
			                <form:errors path="ubicacion.longitud"></form:errors>
			            </div>
			        </spring:bind>
			        
			       <spring:bind path="ubicacion.comuna">
         			   <div class="form-group ${status.error ? 'has-error' : ''}" style = "display:none">
          			  Comuna
           		 			<form:select id="comunaID" path="ubicacion.comuna.id">  
							   <form:options items="${comunas}" itemLabel="nombre" itemValue="id" required="true"/>
							 </form:select>                
              			  <form:errors path="ubicacion"></form:errors>
          				  </div>
       				 </spring:bind>
			        <spring:bind path="diabetico">
			        	<div class="form-group ${status.error ? 'has-error' : ''}">
			                <label>¿Eres Diabetico?
			                <form:checkbox path="diabetico" value="1"></form:checkbox>
			                </label>
			                <form:errors path="diabetico"></form:errors>
			            </div>
			        </spring:bind>
			        <spring:bind path="fechaNacimiento">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                Fecha de Nacimiento (dd/mm/yyyy)
			                <form:input type="text" path="fechaNacimiento" id="datePicker" class="form-control" required="true"></form:input>               
			                <form:errors path="fechaNacimiento"></form:errors>
			            </div>
			        </spring:bind>
			       
			    	  <spring:bind path="fono">
			           <div class="form-group ${status.error ? 'has-error' : ''}">
			           Teléfono
			               <form:input type="text" path="fono" class="form-control" required="true"></form:input>
			               <form:errors path="fono"></form:errors>
			           </div>
				    </spring:bind>
				    <spring:bind path="paramSexo">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
				            Sexo
			            	<form:select path="paramSexo.id">  
							   <form:options items="${sexos}" itemLabel="valor" itemValue="id" required="true" class="form-control"/>
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
	               Foto Perfil<input type="file"  class="form-control" name="fotoPerfil" value="Subir Foto" accept=".png, .jpg, .jpeg"></input>
	                </div>
					 
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
					
			   		 <button class="btn btn-lg btn-primary btn-block" type="submit">Crear cuenta!</button>
			   		 <br> <center><a href="${contextPath}/login">¿Ya tienes cuenta?</a></center>
			   		 <br> <center><a href="/">Volver al Home</a></center>
			   		  <br>
			   		   <br>
			   		    <br>
			    </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript"
			src="http://maps.googleapis.com/maps/api/js?v3&libraries=places&key=AIzaSyAVgzIQhGvX45D1OGk-De6fgj-12xDuZjU"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap-datepicker.js"></script>
	<script src="${contextPath}/resources/js/jquery-ui.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${contextPath}/resources/dist/js/sb-admin-2.js"></script>
    <script src="${contextPath}/resources/js/jquery.rut.chileno.min.js"></script>
    
	<script type="text/javascript">
	$(document).ready(function () {
		$('#rut').rut(); 
		$(':input[type="submit"]').prop('disabled', true);
		var latitud="";
		var longitud="";
		function getLocale(address){
			var geocoder = new google.maps.Geocoder();
			 geocoder.geocode( { 'address': address}, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK)
					{
					latitud=results[0].geometry.location.lat();
					longitud=results[0].geometry.location.lng();
					$("#latitud").val(results[0].geometry.location.lat());
					$("#longitud").val(results[0].geometry.location.lng());
					//console.log(results); 
				    $("#mensajeDirecion").html("Dirección [OK]");
				    $("#mensajeDirecion").css("color", "black");	
				    $("#ubicacion").val(results[0].formatted_address);	
				    validaComuna(results[0].address_components[2].short_name);
				   // console.log(results[0].address_components[2].short_name);
				  //  $("#ubicacion").val("");
					}else{
						 $("#mensajeDirecion").html("Dirección [No encontrada]");
						 $("#mensajeDirecion").css("color", "red");				
					}
		   });
		}			
		$("#ubicacion" ).focusout(function() {
			var address = document.getElementById("ubicacion").value;
			//alert("FOCUS OUT");
			getLocale(address);
		 });	
		
		function validaComuna(address){
			if(address==="Maipú"){
				$("#comunaID").val('1').change();;
				$("#comunaNombre").val(address);
				 $(':input[type="submit"]').prop('disabled', false);
			}else{
				if(address==="Pudahuel"){
					 $(':input[type="submit"]').prop('disabled', false);
					$("#comunaID").val('2').change();;
					$("#comunaNombre").val(address);
				}else{
					 $(':input[type="submit"]').prop('disabled', true);
					 $("#mensajeDirecion").css("color", "red");	
					 $("#mensajeDirecion").html("Dirección [ Sólo Pudahuel y Maipú ]");
				}
			}
		}
		
		
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
