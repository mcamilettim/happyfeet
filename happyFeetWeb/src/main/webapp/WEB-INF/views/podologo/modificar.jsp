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
    <title>Cuido mis pies</title>

    <!-- Bootstrap Core CSS -->
    <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

     <!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Navegación</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextPath}/podologo/index"><img
					src="${contextPath}/resources/img/logo1.png" class="img-responsive"
					style="width: 120px;"></a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown" style="padding-left: 10px;"><Strong>Bienvenid<c:if
							test="${podologo.paramSexo.id==6}">o</c:if><c:if
							test="${podologo.paramSexo.id==7}">a</c:if> ${podologo.nombres}
				</Strong></li>
				<li class="dropdown"><c:if test="${empty mensajesNuevos}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
					</c:if> <c:if test="${not empty mensajesNuevos}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i><span
							class="badge">${mensajesNuevos.size()}</span>
						</a>
					</c:if>
					<ul class="dropdown-menu dropdown-messages">
						<c:if test="${not empty mensajesNuevos}">
							<c:forEach items="${mensajesNuevos}" var="mensajeNuevo">
								<li><a
									href="${contextPath}/podologo/enviarMensaje?rutPaciente=${mensajeNuevo.emisorRut}">
										<strong></strong> <span class="pull-right text-muted"><em>${mensajeNuevo.fecha}</em>
									</span>${mensajeNuevo.cuerpo}
								</a></li>
							</c:forEach>
						</c:if>
						 
						<li><a class="text-center"
							href="${contextPath}/podologo/misMensajes"> <strong>Ver
									todos los mensajes</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul> </li>
					<li class="dropdown"><c:if test="${empty notificaciones}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
					</c:if> <c:if test="${not empty notificaciones}">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
							class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i><span
							class="badge">${notificaciones.size()}</span>
						</a>
					</c:if>
					<ul class="dropdown-menu dropdown-messages">
						<c:if test="${not empty notificaciones}">
							<c:forEach items="${notificaciones}" var="notificacion">
								<li><a
									href="${notificacion.url}&idNotificacion=${notificacion.id}">
										<strong></strong> <span class="pull-right text-muted"><em>${notificacion.fecha}</em>
									</span> ${notificacion.titulo}
								</a></li>
							</c:forEach>
						</c:if>

						<li><a class="text-center"
							href="${contextPath}/podologo/misNotificaciones"> <strong>Ver
									todas las notificaciones</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul></li>

				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="${contextPath}/podologo/modificarDatos"><i
								class="fa fa-gear fa-fw"></i>Mis Datos</a></li>
						<li class="divider"></li>
						<li><a href="<c:url value="/logout" />"><i
								class="fa fa-sign-out fa-fw"></i> Cerrar Sesión</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<c:choose>
									<c:when test="${empty podologo.foto}">
										<img src="${contextPath}/resources/img/sinfoto.jpg"
											class="img-responsive" style="width: 200px;">
									</c:when>
									<c:otherwise>
										<img src="data:image/png;base64,${podologo.foto}"
											class="img-responsive" style="width: 200px;">
									</c:otherwise>
								</c:choose>
								<br>
								<div align="center">
									<span class="text-info text-center"><b>${podologo.nombres}
											${podologo.apellidos}</b></span> <span class="text-info">Podólog<c:if test="${podologo.paramSexo.id==6}">o</c:if><c:if test="${podologo.paramSexo.id==7}">a</c:if></span>
								</div>
							</div> <!-- /input-group -->
						</li>
						<li><a href="${contextPath}/podologo/index"><i
								class="fa fa-home fa-fw"></i> Inicio</a></li>
						<li><a href="${contextPath}/podologo/miAgenda"><i
								class="fa fa-edit fa-fw"></i>Mi Horario</a></li>
						<li><a href="${contextPath}/podologo/misSolicitudes"><i
								class="fa fa-calendar-plus-o fa-fw"></i>Solicitudes de Atención</a></li>
						<li><a href="${contextPath}/podologo/misAtenciones"><i
								class="fa fa-user-md fa-fw"></i> Mis atenciones</a></li>
						<li><a href="${contextPath}/podologo/misMensajes"><i
								class="fa fa-comments fa-fw"></i> Mensajes</a></li>
						<li><a href="${contextPath}/podologo/misEvaluaciones"><i
								class="fa fa-star-half-o fa-fw"></i> Evaluaciones a
								Pacientes</a></li>
						<li><a href="${contextPath}/podologo/modificarDatos"><i
								class="fa fa-gear fa-fw"></i><Strong> Modificar mis datos</Strong></a></li>
								<li><a href="${contextPath}/podologo/cuestionarios"><i
								class="fa fa-question-circle fa-fw"></i> Contestar encuesta</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
              <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                    <c:if test="${mensaje != null}">
	                    <div class="alert alert-success alert-dismissable">
	                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
	                                ${mensaje}
	                     </div>
                     </c:if>
                        <h2 class="page-header"></h2>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Modificar mis datos
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                        <form:form method="POST" modelAttribute="podologoForm"  action="modificarDatos" role="form" enctype="multipart/form-data">
								        <spring:bind path="rut">
								            <div class="form-group ${status.error ? 'has-error' : ''}">
								            Rut
								                <form:input type="text" path="rut" class="form-control" readonly="readonly" required="true"></form:input>
								                <form:errors path="rut"></form:errors>
								            </div>
								        </spring:bind>
								
								        <spring:bind path="nombres">
								            <div class="form-group ${status.error ? 'has-error' : ''}">
								            Nombres
								                <form:input type="text" path="nombres" class="form-control" disabled="" required="true" ></form:input>
								                <form:errors path="nombres"></form:errors>
								            </div>
								        </spring:bind>
								        
								        <spring:bind path="apellidos">
								            <div class="form-group ${status.error ? 'has-error' : ''}">
								            Apellidos
								                <form:input type="text" path="apellidos" class="form-control" readonly="readonly" required="true"></form:input>
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
								        
								        <spring:bind path="ubicacion.comuna">
								            <div class="form-group ${status.error ? 'has-error' : ''}">
								            Comuna: 
								            	<form:select path="ubicacion.comuna.id">  
												   <form:options items="${comunas}" itemLabel="nombre" itemValue="id" required="true" class="form-control"/>
												 </form:select>                
								                <form:errors path="ubicacion"></form:errors>
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
									     
									     <spring:bind path="fono">
								           <div class="form-group ${status.error ? 'has-error' : ''}">
								           Email
								               <form:input type="email" path="email" class="form-control" required="true" readonly="readonly"></form:input>
								               <form:errors path="email"></form:errors>
								           </div>
									    </spring:bind>
									    	<div class="form-group">      
	              							 Foto Perfil<input type="file"
												class="form-control" name="archivo"
												value="${pacienteForm.foto}" accept=".png, .jpg, .jpeg"></input>
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

								   		 <button class="btn btn-lg btn-primary btn-block" type="submit">Guardar</button>

								    </form:form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
               
            <!-- /.container-fluid -->
        </div>
                

               
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    
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
		var address = document.getElementById("ubicacion").value;
		getLocale(address);
		$(':input[type="submit"]').prop('disabled', false);
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
			//console.log(address);
			//console.log(address.localeCompare("Maipú"));
			if(address.localeCompare("Maipú")==0){
				$("#comunaID").val('1').change();;
				$("#comunaNombre").val(address);
				 $(':input[type="submit"]').prop('disabled', false);
			}else{
				if(address.localeCompare("Pudahuel")==0){
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
		
		
		 
	});
	
	</script>
</body>

</html>
